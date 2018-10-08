package net.noordover.springboot.blog.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistration {
        private String username;
        private String password;
        private String passwordConfirmation;
}
