package com.playdata.springbootproject.web;

import com.playdata.springbootproject.service.PostsService;
import com.playdata.springbootproject.web.dto.PostsResponseDto;
import com.playdata.springbootproject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // UI안에 있는 id값을 변수로 가져가는 것이 PathVariable
    public Long update(@PathVariable Long id, @RequestBody PostsSaveRequestDto requestDto){
        //RequestBody - HTTP의 요청으로 body에서 넘겨받은 Json파일
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // UI안에 있는 id값을 변수로 가져가는 것이 PathVariable
    public PostsResponseDto findById(@PathVariable Long id){
        //RequestBody - HTTP의 요청으로 body에서 넘겨받은 Json파일
        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
