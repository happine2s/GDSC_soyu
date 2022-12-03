package com.gdsc.soyu.web;

import com.gdsc.soyu.config.auth.LoginUser;
import com.gdsc.soyu.config.auth.dto.SessionUser;
import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.service.posts.PostsService;
import com.gdsc.soyu.web.dto.CommentResponseDto;
import com.gdsc.soyu.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostsIndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("loginUserName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("loginUserName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findById(id);
        model.addAttribute("posts",dto);

        return "posts-update";
    }
<<<<<<< Updated upstream:src/main/java/com/gdsc/soyu/web/IndexController.java
=======

    @GetMapping("/posts/detail/{id}")
    public String postsDetail(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        List<Comment> comments = dto.getComments();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("loginUserName", user.getName());
        }

        if(comments != null && !comments.isEmpty()){
            model.addAttribute("comments",comments);
        }

        model.addAttribute("posts", dto);
        return "posts-detail";
    }
>>>>>>> Stashed changes:src/main/java/com/gdsc/soyu/web/PostsIndexController.java
}
