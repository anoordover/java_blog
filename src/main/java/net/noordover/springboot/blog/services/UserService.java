package net.noordover.springboot.blog.services;

import java.util.List;
import net.noordover.springboot.blog.entities.User;
import net.noordover.springboot.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public User getUser(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
