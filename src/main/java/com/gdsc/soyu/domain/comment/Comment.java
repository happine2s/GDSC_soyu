package com.gdsc.soyu.domain.comment;

import com.gdsc.soyu.domain.BaseTimeEntity;
import com.gdsc.soyu.domain.posts.Posts;
import com.gdsc.soyu.domain.user.User;
import com.gdsc.soyu.web.dto.CommentSaveRequestDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column
    private String userName;

    @ManyToOne
    @JoinColumn(name="postsId")
    private Posts posts;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private Boolean anonymous;
}
