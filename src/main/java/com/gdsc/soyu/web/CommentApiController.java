package com.gdsc.soyu.web;

import com.gdsc.soyu.config.auth.dto.SessionUser;
import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.domain.comment.CommentRepository;
import com.gdsc.soyu.service.comments.CommentService;
import com.gdsc.soyu.service.posts.PostsService;
import com.gdsc.soyu.web.dto.CommentResponseDto;
import com.gdsc.soyu.web.dto.CommentSaveRequestDto;
import com.gdsc.soyu.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class CommentApiController {
    private final CommentService commentService;
    private final PostsService postsService;
    private final CommentRepository commentRepository;
    private final HttpSession httpSession;

    @PostMapping("/{id}/comments")
    public Long CommentsSave(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return commentService.save(requestDto, id, user.getEmail());
    }

    @DeleteMapping("/{id}/comments/{commentId}")
    public ResponseEntity delete(@PathVariable Long id, @PathVariable Long commentId) {
        commentService.delete(commentId);
        return ResponseEntity.ok(commentId);
    }
}
