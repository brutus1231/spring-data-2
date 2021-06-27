package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;
import pl.sda.model.AccountEntity;
import pl.sda.model.PersonEntity;
import pl.sda.repository.PersonRepository;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        AccountEntity account1 = AccountEntity.builder().accountNumber("1000").state(BigDecimal.valueOf(2000)).build();
        AccountEntity account2 = AccountEntity.builder().accountNumber("2000").state(BigDecimal.valueOf(3000)).build();

        PersonEntity personEntity1 = PersonEntity.builder().firstName("Marcin").lastName("Nowak")
                .account(account1).build();
        PersonEntity personEntity2 = PersonEntity.builder().firstName("Piotrek").lastName("Kowalski")
                .account(account2).build();

        personRepository.save(personEntity1);
        personRepository.save(personEntity2);

//        personRepository.findAll().forEach(System.out::println);

        personRepository.findByFirstName("Piotrek").forEach(System.out::println);
    }
}
