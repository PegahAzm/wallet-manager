create table USR_AZIMI.WALLET
(
    USER_ID NUMBER,
    AMOUNT  NUMBER(20)
)
    /

create table USR_AZIMI.TRANSACTION_WALLETS
(
    USER_ID          NUMBER,
    AMOUNT           NUMBER(20),
    CURRENT_BALANCE  NUMBER(20),
    AFTER_BALANCE    NUMBER(20),
    REFERENCE_NUMBER CHAR(10),
    ID               NUMBER(5)
)
    /
create sequence TRANSACTION_ID