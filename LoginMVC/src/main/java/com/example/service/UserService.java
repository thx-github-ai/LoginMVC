package com.example.service;

import com.example.entity.User;
import com.example.entity.vo.MessageModel;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import com.example.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * 业务逻辑
 */
public class UserService {
    public MessageModel userLogin(String userName, String userPassword) {
        MessageModel messageModel = new MessageModel();
        User u = new User();
        u.setUserName(userName);
        u.setUserPassword(userPassword);
        messageModel.setObject(u);
//        开始登陆
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(userPassword)) {
            messageModel.setCode(0);
            messageModel.setMessage("用户名和密码不能为空");
            return messageModel;
        }
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(userName);

        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMessage("用户名不存在！");
            return messageModel;
        }
        if (!userPassword.equals(user.getUserPassword())) {
            messageModel.setCode(0);
            messageModel.setMessage("密码不对！");
            return messageModel;
        }
//       登陆成功
        messageModel.setObject(user);


        return messageModel;
    }
}
