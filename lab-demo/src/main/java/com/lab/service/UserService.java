package com.lab.service;

import com.lab.mapper.UserMapper;
import com.lab.util.SqlSessionFactoryUtils;
import com.lab.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

//public class UserService {
//    //1.使用工具类获取SqlSessionFactory
//    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
//
//    /***
//     * 登录方法
//     * @param username
//     * @param password
//     * @return
//     */
//    public User login(String username,String password){
//        //2.获取SqlSession
//        SqlSession sqlSession = factory.openSession();
//        //3.获取UserMapper
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //4.调用方法
//        User user = mapper.select(username,password);
//        //释放资源
//        sqlSession.close();
//        return user;
//    }
//
//    /**
//     * 注册方法
//     * @return
//      */
//    public boolean register(User user){
//        //2.获取SqlSession
//        //2.获取SqlSession
//        SqlSession sqlSession = factory.openSession();
//        //3.获取UserMapper
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        //4.判断用户名是否存在
//        User u =mapper.selectByUsername(user.getUsername());
//
//        if(u ==null){
//            //用户名不存在，可以注册
//            mapper.add(user);
//            sqlSession.commit();
//        }
//        sqlSession.close();
//        return u ==null;
//    }
//}
public class UserService {
    //1.使用工具类获取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 调用方法
        User user = mapper.select(username, password);
        //释放资源
        sqlSession.close();

        return  user;
    }
    /**
     * 注册方法
     * @return
     */

    public boolean register(User user){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if(u == null){
            // 用户名不存在，注册
            mapper.addUser(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u == null;

    }

    /**
     * 查询所有
     * @return
     */
    public List<User> selectUserAll(){
        //调用BrandMapper.selectAll()

        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        List<User> users = mapper.selectUserAll();

        sqlSession.close();

        return users;
    }
}


