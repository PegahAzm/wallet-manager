package com.wallet.manager.repository;

import com.wallet.manager.repository.repository.TransactionRepository;
import com.wallet.manager.repository.repository.WalletRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryUnitTest {

    @Autowired
    TransactionRepository  transactionRepository;

    @Autowired
    WalletRepository walletRepository;


    @Test
    public void setTransactionRepository()
    {
        TransactionEntity entity = new TransactionEntity();
        entity.setUserId(2);
        entity.setAmount(9000l);
        entity.setReferenceNumber("7854632587");
        entity.setCurrentBalance(50l);
        entity.setAfterBalance(9050l);

        TransactionEntity result  = transactionRepository.save(entity);

        Assert.assertNotNull(result);
    }

    @Test
    public void findWalletManager()
    {
        WalletEntity wallet = walletRepository.findDistinctByUserId(5);
        Assert.assertNull(wallet);

    }



}
