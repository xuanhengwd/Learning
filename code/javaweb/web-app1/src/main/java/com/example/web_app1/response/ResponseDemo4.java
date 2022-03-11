package com.example.web_app1.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FileInputStream fs = new FileInputStream("C:\\Users\\24564\\Desktop\\test\\test.jpg");
        ServletOutputStream os = response.getOutputStream();

//        byte[] buffer = new byte[1024];
//        int len;
//        while((len=fs.read(buffer))!=-1){
//            os.write(buffer,0,len);
//        }

        //简便
        IOUtils.copy(fs,os);
        fs.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
