package com.wallet.manager.services;


import com.wallet.manager.dto.TransactionInfo;
import com.wallet.manager.dto.UserAmount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WalletManagerServiceTest {


    @Autowired
    private WalletManagerService service;

    @Test
    public void retriveBalanceTest()
    {
        UserAmount userAmount = service.getUserAmount(2);

        Assertions.assertNotNull(userAmount);
    }

    @Test
    public void doTransactionTest()
    {
        TransactionInfo transactionInfo = service.addAmount(2,Long.valueOf(-4000));

        Assertions.assertNotNull(transactionInfo);
    }
}
