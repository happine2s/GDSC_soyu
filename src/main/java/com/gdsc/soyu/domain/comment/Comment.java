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

    @Column
    private Long userId;

    @Column
    private String userName;

    @ManyToOne
    @JoinColumn(name="posts")
    private Posts posts;


    @Column(nullable = true)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private Boolean anonymous;
}
