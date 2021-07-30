package com.example.test;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Text {
    public static void main(String[] args) {
//        获取 SQLSession 对象
        SqlSession session = GetSqlSession.createSqlSession();
//        获得对应的 Mapper 值
        UserMapper userMapper = session.getMapper(UserMapper.class);
//         调用方法，返回用户对象
        User user = userMapper.queryUserByName("root");
        System.out.println(user);
    }
}
