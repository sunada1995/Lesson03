package com.seiken_soft.model;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface DutyRegistModel {
  //勤怠画面用のモデルインターフェース
	//@Select("SELECT * FROM users WHERE id = #{id}")
    //User getUserById(Long id);
    @Insert("INSERT INTO t_duty(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
    //@Update("UPDATE users SET name = #{name}, email = #{email} WHERE id = #{id}")
    //int updateUser(User user);
    //@Delete("DELETE FROM users WHERE id = #{id}")
    //int deleteUser(Long id);
	
}
