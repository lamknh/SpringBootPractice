package com.example.demo.controller;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 프레임워크가 클래스를 컨트롤러로 인식하고 컨트롤러 인스턴스 생성
public class UserProfileController {
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper){ //생성자로 내부 레퍼런스에 저장 (알아서 mapper 만들고 컨트롤러랑 연결)
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}") //패스의 변수 이용위해 어노테이션
    public UserProfile getUserProfile(@PathVariable("id") String id){
        return mapper.getUserProfile(id); //mapper sql 수행 후 java 객체로 반환 후 json 형태로 전달
    }

    @GetMapping("/user")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                               @RequestParam("phone") String phone, @RequestParam("address")String address){ //http param 형태로 전달받음
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PostMapping("/user/{id}") //수정은 주로 Post 방식으로 처리
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                @RequestParam("phone") String phone, @RequestParam("address")String address){
        mapper.postUserProfile(id, name, phone, address);
    }

    @DeleteMapping
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }

}
