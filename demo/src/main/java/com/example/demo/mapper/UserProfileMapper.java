package com.example.demo.mapper;

import com.example.demo.model.UserProfile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //mapper로 스프링부트가 인식
public interface UserProfileMapper {
    @Select("SELECT * FROM UserProfile WHERE id=#{id}") //param id 전달 - param 연결시 # 으로해야 @Param으로 맵핑
    UserProfile getUserProfile(@Param("id") String id);

    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();

    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
                       @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int postUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
                        @Param("address") String address);

    @Delete("DELETE FROM UserProfile WHERE id=#{id}")
    int deleteUserProfile(@Param("id") String id);

    //성공적으로 수행될 시 1 반환
}
