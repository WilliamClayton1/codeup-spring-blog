package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    public String post(Model model) {

        ArrayList<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        Post post2 = new Post();

        post1.setTitle("Title1");
        post1.setBody("Body1");

        post2.setTitle("Title2");
        post2.setBody("Body2");

        postList.add(post1);
        postList.add(post2);

        model.addAttribute("postList", postList);
        return "posts/index";


    }

    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
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
