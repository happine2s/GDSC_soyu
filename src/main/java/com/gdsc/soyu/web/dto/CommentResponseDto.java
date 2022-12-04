package com.gdsc.soyu.web.dto;

import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.domain.posts.Posts;
import com.gdsc.soyu.domain.user.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CommentResponseDto {
    private Long id;
    private Long postsId;
    private User user;
    private String content;
    private Boolean anonymous;

    public CommentResponseDto(Comment entity){
        this.id=entity.getId();
        this.postsId=entity.getPosts().getId();
        this.user=entity.getUser();
        this.content=entity.getContent();
        this.anonymous=entity.getAnonymous();
    }
}