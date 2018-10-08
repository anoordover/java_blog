package net.noordover.springboot.blog.repositories;

import java.util.List;
import net.noordover.springboot.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {
        List<Post> findByCreatorId(Long id);
}
