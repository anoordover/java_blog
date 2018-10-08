package net.noordover.springboot.blog.services;

import java.util.List;
import net.noordover.springboot.blog.entities.Post;
import net.noordover.springboot.blog.entities.User;
import net.noordover.springboot.blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

        @Autowired
        private BlogRepository blogRepository;

        public List<Post> getAllPosts() {
                return blogRepository.findAll();
        }

        public void insert(Post post) {
                blogRepository.save(post);
        }

        public List<Post> findByUser(User user) {
                return blogRepository.findByCreatorId(user.getId());
        }
}
