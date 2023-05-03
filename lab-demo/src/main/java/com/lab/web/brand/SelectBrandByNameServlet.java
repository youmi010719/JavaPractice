package com.lab.web.brand;

import com.lab.pojo.Brand;
import com.lab.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectBrandByNameServlet")
public class SelectBrandByNameServlet extends HttpServlet {
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收brandName
        String brandName = request.getParameter("brandName");
        //2. 调用service查询
        Brand brand = service.selectBrandByName("brandName");
        //3. 存储到request中
        request.setAttribute("brand",brand);
        //4. 转发到selectByName.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
