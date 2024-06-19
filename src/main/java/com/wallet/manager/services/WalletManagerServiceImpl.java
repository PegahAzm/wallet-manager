package com.wallet.manager.services;

import com.wallet.manager.dto.TransactionInfo;
import com.wallet.manager.dto.UserAmount;
import com.wallet.manager.repository.TransactionEntity;
import com.wallet.manager.repository.WalletEntity;
import com.wallet.manager.repository.repository.TransactionRepository;
import com.wallet.manager.repository.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class WalletManagerServiceImpl implements WalletManagerService{

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;

    public WalletManagerServiceImpl(TransactionRepository transactionRepository, WalletRepository walletRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public UserAmount getUserAmount(Integer userId) {

        WalletEntity entity ;
        try {
            entity = walletRepository.findDistinctByUserId(userId);
        }catch (Exception exception)
        {
            logger.error("problem on reading data from  wallet table");
            throw exception;
        }

        UserAmount userAmount = new UserAmount();
        if(entity != null)
          userAmount.setAmount(entity.getAmount());
        else
            userAmount.setAmount(0l);

        return userAmount;
    }

    @Override
    public TransactionInfo addAmount(Integer userId, Long amount) {

        TransactionInfo transactionInfo = new TransactionInfo();
        TransactionEntity entity = saveTransaction(userId , amount);
        if(entity != null)
            transactionInfo.setReferenceNumber( entity.getReferenceNumber());
        else
            transactionInfo.setReferenceNumber("0");

        return transactionInfo;
    }

    private String calculateReferenceNumber()
    {
        logger.trace("create Reference_Number");
        Random random = new Random();
        long randomNumber = 1000000000L + (long)(random.nextDouble() * (9999999999L - 1000000000L));

        return String.valueOf(randomNumber);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TransactionEntity  saveTransaction(Integer userId, Long amount)
    {
        logger.trace("first read data from wallet table ");
        WalletEntity entity ;
        try {
            entity = walletRepository.findDistinctByUserId(userId);
        }catch (Exception exception)
        {
            logger.error("problem on reading data from wallet table ");
            throw exception;
        }

        TransactionEntity result = null;
        if(entity != null) {
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setUserId(entity.getUserId());
            transactionEntity.setAmount(amount);
            transactionEntity.setCurrentBalance(entity.getAmount());
            transactionEntity.setAfterBalance(entity.getAmount() + amount);
            transactionEntity.setReferenceNumber(calculateReferenceNumber());

            try {
                logger.trace("save  data into  transaction_wallet table ");
                 result = transactionRepository.save(transactionEntity);
                 entity.setAmount(result.getAfterBalance());
                logger.trace("update new amount into wallet table ");
                 walletRepository.save(entity);

            }catch (Exception exception)
            {
                throw exception;
            }
        }
        return result;

    }
}
