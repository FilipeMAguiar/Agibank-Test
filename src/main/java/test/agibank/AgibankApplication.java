package test.agibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AgibankApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgibankApplication.class, args);
    }

}
