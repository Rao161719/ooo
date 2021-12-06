package com.example.ooo;

import com.example.dao.DaoTestImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ServletSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置输出格式
        /*response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();*/

        //调用方法查询数据
        DaoTestImpl dao = new DaoTestImpl();
        List stu = dao.getStudent();
        /*String s = stu.toString();
        writer.write(s);*/

        //在全局作用域中存入数据
        request.getServletContext().setAttribute("key",stu);
        System.out.println("存入成功...");
        //方法一:重定向
//        response.sendRedirect("/ooo/select.jsp");
        //方法二:请求转发
//        request.getRequestDispatcher("/select.jsp").forward(request,response);
        response.sendRedirect("/ooo/select.jsp");
        System.out.println("转发成功...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
