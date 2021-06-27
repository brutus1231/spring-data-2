package pl.sda.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MoneyTransferExecutor {

    @Transactional
    public void send(String senderAccount, String receiverAccount) {

    }
}
