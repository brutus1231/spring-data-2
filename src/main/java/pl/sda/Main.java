package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;
import pl.sda.model.PersonEntity;
import pl.sda.repository.PersonRepository;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        PersonEntity personEntity = PersonEntity.builder().firstName("Marcin").lastName("Nowak").build();
        personRepository.save(personEntity);
    }
}
