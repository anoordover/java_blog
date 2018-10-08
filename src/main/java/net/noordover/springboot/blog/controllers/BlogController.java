package net.noordover.springboot.blog.controllers;

import java.util.Date;
import java.util.List;
import net.noordover.springboot.blog.entities.Post;
import net.noordover.springboot.blog.services.PostService;
import net.noordover.springboot.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

        @Autowired
        private PostService postService;
        @Autowired
        private UserService userService;

        @GetMapping("/posts")
        public List<Post> posts() {
                return postService.getAllPosts();
        }

        @PostMapping("/post")
        @ResponseStatus(HttpStatus.CREATED)
        public String publishPost(@RequestBody Post post) {
                UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (post.getDateCreated() == null)
                        post.setDateCreated(new Date());
                post.setCreator(userService.getUser(userDetails.getUsername()));
                postService.insert(post);
                return "Post published";
        }

        @GetMapping("/posts/{username}")
        public List<Post> postsByUsername(@PathVariable String username) {
                return postService.findByUser(userService.getUser(username));
        }
}
