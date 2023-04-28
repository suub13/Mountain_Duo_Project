package com.playdata.springbootproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

//    List<User> findByName(String name);
//    List<User> findByAgeGreaterThanAndName(int age, String name);
}
