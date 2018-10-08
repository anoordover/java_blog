package net.noordover.springboot.blog;

import java.util.Arrays;
import net.noordover.springboot.blog.entities.Role;
import net.noordover.springboot.blog.entities.User;
import net.noordover.springboot.blog.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogApplication {

        @Bean
        public CommandLineRunner setupDefaultUser(UserService service) {
                return args -> {
                        service.save(new User(
                            "user", //username
                            "password", //password
                            Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
                            true//Active
                        ));
                        service.save(new User(
                            "usertwo", //username
                            "password", //password
                            Arrays.asList(new Role("USER"), new Role("ACTUATOR")),//roles
                            true//Active
                        ));
                };
        }

        public static void main(String[] args) {
                SpringApplication.run(BlogApplication.class, args);
        }

        @Bean
        public PasswordEncoder getPasswordEncoder(){
                return new BCryptPasswordEncoder();
        }
}
