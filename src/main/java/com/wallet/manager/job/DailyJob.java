package com.wallet.manager.job;

import com.wallet.manager.repository.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class DailyJob {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TransactionRepository transactionRepository;

//    @Scheduled(cron = "0 0 0 * * *")
    @Scheduled(cron = "0 * * * * *")
    public void performDailyTask() {

        try {
            double totalAmount =  transactionRepository.getTotalAmount();
            System.out.println("Today total amount is " + totalAmount );
        }catch (Exception ex)
        {
            logger.error("there is problem to read data " , ex);
        }

    }
}
