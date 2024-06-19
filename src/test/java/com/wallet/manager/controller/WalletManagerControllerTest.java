package com.wallet.manager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.manager.controller.WalletManagerController;
import com.wallet.manager.dto.TransactionInfo;
import com.wallet.manager.dto.UserAmount;
import com.wallet.manager.services.WalletManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.when;



@SpringBootTest
@AutoConfigureMockMvc
public class WalletManagerControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletManagerService service;


    @Test
    public void testGetBalanceOfUser() throws Exception {

        Integer userId = 1;
        UserAmount mockUserAmount = new UserAmount();
        mockUserAmount.setAmount(5000l);


        when(service.getUserAmount(userId)).thenReturn(mockUserAmount);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/wallet_manager/balance")
                        .param("userId", userId.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value(5000l));
    }


    @Test
    public void testAddTransaction() throws Exception {

        Integer userId = 1;
        Long amount = 5000l;
        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setReferenceNumber("8795642587");



        when(service.addAmount(userId,amount)).thenReturn(transactionInfo);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/wallet_manager/do-transaction")
                        .param("userId", userId.toString())
                        .param("amount", amount.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.referenceNumber").value("8795642587"));
    }
}
