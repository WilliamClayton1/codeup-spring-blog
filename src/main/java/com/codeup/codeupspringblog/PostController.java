package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    @ResponseBody
    public String post() {
        return "posts index page";
    }

    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPostId(@PathVariable int id, Model model) {
        Post post = new Post();

        post.setTitle("Title");
        post.setBody("Body");

        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreatePost() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }

}
