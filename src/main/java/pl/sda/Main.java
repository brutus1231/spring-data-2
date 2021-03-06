package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;
import pl.sda.model.AccountEntity;
import pl.sda.model.PersonEntity;
import pl.sda.repository.AccountRepository;
import pl.sda.repository.PersonRepository;
import pl.sda.service.MoneyTransferExecutor;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        savePersons(personRepository);

//        personRepository.findAll().forEach(System.out::println);

        //personRepository.findByFirstName("Piotrek").forEach(System.out::println);

        MoneyTransferExecutor moneyTransferExecutor = context.getBean(MoneyTransferExecutor.class);

        try{
            moneyTransferExecutor.send("1000", "2000", BigDecimal.TEN);
        } catch (Exception ex){}


        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        accountRepository.findAll().forEach(System.out::println);
    }

    private static void savePersons(PersonRepository personRepository) {
        personRepository.deleteAll();
        AccountEntity account1 = AccountEntity.builder().accountNumber("1000").state(BigDecimal.valueOf(2000)).build();
        AccountEntity account2 = AccountEntity.builder().accountNumber("2000").state(BigDecimal.valueOf(3000)).build();

        PersonEntity personEntity1 = PersonEntity.builder().firstName("Marcin").lastName("Nowak")
                .account(account1).build();
        PersonEntity personEntity2 = PersonEntity.builder().firstName("Piotrek").lastName("Kowalski")
                .account(account2).build();

        personRepository.save(personEntity1);
        personRepository.save(personEntity2);
    }
}
