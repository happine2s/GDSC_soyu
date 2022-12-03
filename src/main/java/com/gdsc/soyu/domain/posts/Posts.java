package com.gdsc.soyu.domain.posts;

import com.gdsc.soyu.domain.BaseTimeEntity;
import com.gdsc.soyu.domain.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    //포스트 테이블에 유저 객체랑 왜 연결을 안했지...?
    //포스트 객체 유저와의 관계 다시 보기...
    private String author;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //게시물 삭제->댓글도 삭제
    @OrderBy("id asc")
    private List<Comment> comments;

    @Builder //생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
