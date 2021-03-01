package Controller;

import Model.DbUtil;
import Model.User;
import Model.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //创建两个变量暂存前端传来的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建进行数据库连接对象
        DbUtil db = new DbUtil();
        //使用User对象储存前后端传输的姓名，密码数据
        User user = new User(username,password);
        //创建数据库操作对象，根据不同服务进行不同数据库操作
        Dao dao = new Dao();
        try {
            //进行数据库连接
            Connection con = db.getcon();
            if(dao.login(con,user) != null){    //进行登陆功能的数据库操作，传入数据库连接和前端数据对象
                response.sendRedirect("ok.jsp");//登陆成功之后跳转的页面
            }else {
                response.sendRedirect("register.jsp");//登陆失败之后跳转到注册界面
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
