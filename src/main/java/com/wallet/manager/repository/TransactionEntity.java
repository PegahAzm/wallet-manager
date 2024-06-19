package com.wallet.manager.repository;


import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION" )
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_ID" )
    @SequenceGenerator(name = "TRANSACTION_ID", sequenceName = "TRANSACTION_ID" , allocationSize = 1)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "CURRENT_BALANCE")
    private Long currentBalance;

    @Column(name = "AFTER_BALANCE")
    private Long afterBalance;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

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

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(Long afterBalance) {
        this.afterBalance = afterBalance;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
