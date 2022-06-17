package com.example.demo.WEB;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.services.BlogService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog2")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public Blog getBlogBy(@PathVariable int userId, @PathVariable int blogId ){
        return blogService.getBlogBy(userId,blogId);
    }

    @RequestMapping()
    public ModelAndView displayBlog(){
        ModelAndView modelAndView = new ModelAndView();

        List<Blog> blogs = blogService.getAllBlogs();
        modelAndView.setViewName("blog");
        modelAndView.addObject("blogs",blogService.getAllBlogs());
        return modelAndView;
    }


}
