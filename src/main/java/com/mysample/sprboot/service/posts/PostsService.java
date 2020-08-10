package com.mysample.sprboot.service.posts;

import com.mysample.sprboot.domain.posts.Posts;
import com.mysample.sprboot.domain.posts.PostsRepository;
import com.mysample.sprboot.web.dto.PostsListResponseDto;
import com.mysample.sprboot.web.dto.PostsResponseDto;
import com.mysample.sprboot.web.dto.PostsSaveRequestDto;
import com.mysample.sprboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                        .orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
            return postsRepository.findAllDesc().stream()
                    .map(PostsListResponseDto::new)
                    .collect(Collectors.toList());
    }
}

