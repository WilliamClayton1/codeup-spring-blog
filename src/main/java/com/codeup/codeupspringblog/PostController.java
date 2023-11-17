package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
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
    public String getPostId(@PathVariable String id) {
        return "view an individual post";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreateForm() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }

}
