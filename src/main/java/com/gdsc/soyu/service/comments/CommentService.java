package com.gdsc.soyu.service.comments;

import com.gdsc.soyu.domain.comment.Comment;
import com.gdsc.soyu.domain.comment.CommentRepository;
import com.gdsc.soyu.domain.posts.Posts;
import com.gdsc.soyu.domain.posts.PostsRepository;
import com.gdsc.soyu.domain.user.User;
import com.gdsc.soyu.domain.user.UserRepository;
import com.gdsc.soyu.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto, Long postId, String email){
        Optional<User> userOptional=userRepository.findByEmail(email);
        Posts posts=postsRepository.findById(postId).orElseThrow(()->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다."+postId));

        requestDto.setUser(userOptional.get());
        requestDto.setPosts(posts);
        requestDto.setUserName(requestDto.getUser().getName());

        Comment comment=requestDto.toEntity();
        commentRepository.save(comment);

        return comment.getId();
    }
}