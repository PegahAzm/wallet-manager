package com.wallet.manager.controller;


import com.wallet.manager.dto.TransactionInfo;
import com.wallet.manager.dto.UserAmount;
import com.wallet.manager.services.WalletManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet_manager")
public class WalletManagerController {

    @Autowired
    private WalletManagerService service;

    @GetMapping(value = "/balance")
    public UserAmount getBalanceOfUser(Integer userId) {
        return service.getUserAmount(userId);
    }

    @GetMapping(value = "/do-transaction")
    public TransactionInfo addTransaction(Integer userId,Long amount) {
        return service.addAmount(userId,amount);
    }

}
