package com.example.ooo;

import com.example.dao.DaoTestImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("no");
        DaoTestImpl dao = new DaoTestImpl();
        int count = dao.delStudent(no);
        System.out.println("Delete:"+count);
        if(count == 0){
            /*重定向*/
//            request.getRequestDispatcher("/error.jsp").forward(request,response);
            /*请求转发*/
            response.sendRedirect("/error.jsp");
        }else {
//            request.getRequestDispatcher("/ooo/select").forward(request,response);
            response.sendRedirect("/ooo/select");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
