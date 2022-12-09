package com.gdsc.soyu.web;

import com.gdsc.soyu.config.auth.dto.SessionUser;
import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.service.comments.CommentService;
import com.gdsc.soyu.service.posts.PostsService;
import com.gdsc.soyu.web.dto.CommentSaveRequestDto;
import com.gdsc.soyu.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class CommentApiController {
    private final CommentService commentService;
    private final PostsService postsService;
    private final HttpSession httpSession;

    @PostMapping("/{id}/comments")
    public Long CommentsSave(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        System.out.println(id);

        return commentService.save(requestDto, id, user.getEmail());
    }

    /* DELETE */
    @DeleteMapping("/{id}/comments/{commentId}")
    public ResponseEntity delete(@PathVariable Long id, @PathVariable Long commentId) {
        System.out.println("댓글 id: "+commentId);
        commentService.delete(commentId);
        return ResponseEntity.ok(commentId);
    }
}
