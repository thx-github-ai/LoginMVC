package com.example.controller;

import com.example.entity.User;
import com.example.entity.vo.MessageModel;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
//    实例化 UserService 对象
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
//        调用 service 方法
        MessageModel messageModel = userService.userLogin(userName, userPassword);
        if (messageModel.getCode() == 1) {
            request.getSession().setAttribute("user", messageModel.getObject());
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("messageModel",messageModel );
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }
}
