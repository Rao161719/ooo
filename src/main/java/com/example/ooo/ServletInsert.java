package com.example.ooo;

import com.example.dao.DaoTestImpl;
import com.example.dao.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String aClass = request.getParameter("class");
        System.out.println(no);

        Student stu = new Student(no,name,sex,birthday,aClass);

        DaoTestImpl dao = new DaoTestImpl();
        int count = dao.inStudent(stu);

        if(count == 0){
//            request.getRequestDispatcher("/error.jsp").forward(request,response);
            response.sendRedirect("/ooo/error.jsp");
        }else {
//            request.getRequestDispatcher("/select").forward(request,response);
            response.sendRedirect("/ooo/select");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
