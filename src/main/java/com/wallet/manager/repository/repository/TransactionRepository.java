package com.wallet.manager.repository.repository;

import com.wallet.manager.repository.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query(value = "SELECT SUM(AMOUNT) AS totalAmount "
            + "FROM TRANSACTION_WALLETS", nativeQuery = true)
    double getTotalAmount();
}
