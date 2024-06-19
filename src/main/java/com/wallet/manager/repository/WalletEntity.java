package com.wallet.manager.repository;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WALLET" )
public class WalletEntity {

    @Id
    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="AMOUNT")
    private Long amount;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
