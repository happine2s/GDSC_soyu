package com.gdsc.soyu.web.dto;

import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.domain.posts.Posts;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;


    public PostsResponseDto(Posts entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
        this.comments= entity.getComments();
    }
}
