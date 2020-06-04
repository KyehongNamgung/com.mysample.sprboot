package com.mysample.sprboot.web;

import com.mysample.sprboot.service.posts.PostsService;
import com.mysample.sprboot.web.dto.HelloResponseDto;
import com.mysample.sprboot.web.dto.PostsResponseDto;
import com.mysample.sprboot.web.dto.PostsSaveRequestDto;
import com.mysample.sprboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public HelloResponseDto save(@RequestBody PostsSaveRequestDto requestDto) {
        HelloResponseDto dt = new HelloResponseDto("남궁계홍",1);
        postsService.save(requestDto);
        return dt;
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
