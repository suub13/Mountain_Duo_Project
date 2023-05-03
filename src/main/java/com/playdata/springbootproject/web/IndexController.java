package com.playdata.springbootproject.web;

import com.playdata.springbootproject.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // Json이 아니라 그냥 view로 보내주는 것
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        // Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
        model.addAttribute("posts", postsService.findAllDesc());

        return "index"; // view resolve라는 것이 /src/main/resources/template/ + "index" + .mustache 형식으로 보내줌
    }

    @GetMapping("/posts/save")
    public String savePost(){
        return "posts-save"; //view resolver 안에 경로 값이 설정되어있음.
    }

    @GetMapping("/posts/{id}")
    public String updatePost(Model model, @PathVariable Long id){
        model.addAttribute("post", postsService.findById(id));
        return "posts-update";
    }


}
