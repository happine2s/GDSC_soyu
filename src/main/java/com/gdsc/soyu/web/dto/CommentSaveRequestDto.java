package com.gdsc.soyu.web.dto;

import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.domain.posts.Posts;
import com.gdsc.soyu.domain.user.User;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data //이건 무슨 어노테이션이지...
public class CommentSaveRequestDto {
    private Long id;
    private Posts posts;
    private User user;
    private String content;
    private Boolean anonymous;
    private String userName;

    @Builder

    public CommentSaveRequestDto(Posts posts,User user, String content, Boolean anonymous, String userName){
        this.posts=posts;
        this.user=user;
        this.content=content;
        this.anonymous=anonymous;
        this.userName=userName;
    }

    public Comment toEntity(){
         return Comment.builder()
                 .id(id)
                 .posts(posts)
                 .user(user)
                 .content(content)
                 .anonymous(anonymous)
                 .userName(userName)
                 .build();
    }
}
