package pl.sda.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.model.AccountEntity;
import pl.sda.repository.AccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MoneyTransferExecutor {

    private final AccountRepository accountRepository;

    @Transactional
    public synchronized void send(String senderAccountNumber, String receiverAccountNumber, BigDecimal value) {
        AccountEntity senderAccount = accountRepository.findFirstByAccountNumber(senderAccountNumber);
        AccountEntity receiverAccount = accountRepository.findFirstByAccountNumber(receiverAccountNumber);

        if (senderAccount.getState().compareTo(value) >= 0) {
            senderAccount.addMoney(value);
            receiverAccount.subtractMoney(value);
        }
    }
}
