package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.service.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    private final UserRepository userDao;
    private final EmailService emailService;

    //Dependency Injection
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    //Show all post in the index page
    @RequestMapping(path = "/post", method = RequestMethod.GET)
    public String post(Model model) {

        model.addAttribute("postList", postDao.findAll());

        return "posts/index";
    }

    //Show a post based on the id
    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    public String getPostId(@PathVariable long id, Model model) {

        Post post = postDao.getPostById(id);

        model.addAttribute("post", post);

        return "posts/show";
    }

    //Show the page to create a post
    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    public String getCreatePost(Model model) {

        model.addAttribute("post", new Post());

        return "posts/create";
    }


    //Create a post
    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute Post post) {

       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getId());

        post.setUser(user);

        postDao.save(post);

        emailService.prepareAndSend(post);

        return "redirect:/post";
    }

    //Show the page to edit a post
    @RequestMapping(path = "/post/{id}/edit", method = RequestMethod.GET)
    public String getEditPost(@PathVariable long id, Model model) {

        Post post = postDao.getPostById(id);

        model.addAttribute("post", post);

        return "posts/edit";
    }

    //Update a post
    @RequestMapping(path = "/post/{id}/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute Post post) {

        postDao.save(post);

        return "redirect:/post";
    }


}
