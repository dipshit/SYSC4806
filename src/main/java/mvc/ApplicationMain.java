package mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationMain {

    private static final Logger log = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository arepository, BuddyRepository brepository) {
        return (args) -> {
        };
    }

}