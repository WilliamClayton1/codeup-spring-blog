package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
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
    public String getCreatePost() {
        return "posts/create";
    }


    //Create a post
    @RequestMapping(path = "/post/create", method = RequestMethod.POST)

    public String postCreate(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {

        Post post = new Post(title, body);

        postDao.save(post);

        return "redirect:/post";
    }

}
