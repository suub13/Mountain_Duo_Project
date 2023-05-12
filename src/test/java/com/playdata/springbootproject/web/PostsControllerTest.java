package com.playdata.springbootproject.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void loadMainPage(){
        //when
        String body = this.testRestTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("Mustache 시작 페이지 입니다.");

    }
}
