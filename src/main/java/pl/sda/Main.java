package pl.sda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sda.config.ApplicationConfiguration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
