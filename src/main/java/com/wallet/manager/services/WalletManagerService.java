package com.wallet.manager.services;

import com.wallet.manager.dto.TransactionInfo;
import com.wallet.manager.dto.UserAmount;

public interface WalletManagerService {

    UserAmount getUserAmount(Integer userId);

    TransactionInfo addAmount(Integer userId , Long amount);
}
