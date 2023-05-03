package com.lab.web.user;

import com.lab.pojo.User;
import com.lab.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectUserAllServlet")
public class SelectUserAllServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用UserService完成查询
        List<User> users = service.selectUserAll();
        //2. 存入request域中
        request.setAttribute("users",users);
        //3. 转发到user.jsp
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
