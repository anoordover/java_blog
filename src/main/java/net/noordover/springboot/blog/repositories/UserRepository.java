package net.noordover.springboot.blog.repositories;

import java.util.Optional;
import net.noordover.springboot.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
