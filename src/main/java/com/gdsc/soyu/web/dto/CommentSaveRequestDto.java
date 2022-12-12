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
    private Long userId;
    private String comment;
    private Boolean anonymous;
    private String userName;

    @Builder

    public CommentSaveRequestDto(Posts posts,Long userId, String content, Boolean anonymous, String userName){
        this.posts=posts;
        this.comment=content;
        this.userId=userId;
        this.anonymous=anonymous;
        this.userName=userName;
    }

    public Comment toEntity(){
         return Comment.builder()
                 .id(id)
                 .posts(posts)
                 .content(comment)
                 .userId(userId)
                 .anonymous(anonymous)
                 .userName(userName)
                 .build();
    }
}
