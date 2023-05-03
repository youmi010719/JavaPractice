package com.lab.mapper;

import com.lab.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名和密码查询对象
     * @parma username
     * @parma password
     * @return
     */
    //这里是需要查找几个吗
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    /*@Select("select * from user_table where username =#{username} and password = #{password}");*/
    User select(@Param("username") String username, @Param("password")  String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into tb_user values(null,#{username},#{password},#{email},#{userwork})")
    void addUser(User user);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_user")
    List<User> selectUserAll();
}
