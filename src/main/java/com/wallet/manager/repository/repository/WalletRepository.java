package com.wallet.manager.repository.repository;

import com.wallet.manager.repository.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {

    WalletEntity findDistinctByUserId(Integer userID);
}
