package pl.sda.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.model.AccountEntity;
import pl.sda.repository.AccountRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MoneyTransferExecutor {

    private final AccountRepository accountRepository;

    @Transactional
    public void send(String senderAccountNumber, String receiverAccountNumber) {
        AccountEntity senderAccount = accountRepository.findFirstByAccountNumber(senderAccountNumber);
        AccountEntity receiverAccount = accountRepository.findFirstByAccountNumber(receiverAccountNumber);


    }
}
