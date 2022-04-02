package com.controller;

import com.model.Product;
import com.service.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchData", value = "/SearchData")
public class SearchData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int productID = Integer.parseInt(request.getParameter("productID"));
        Product product = new ProductDAO().getProductByProductID(productID);
        PrintWriter out = response.getWriter();
        if (product != null) {
            out.println("<table>");
            out.println("<tr><th>Product ID</th><th>Product Details</th></tr>");
            out.println("<tr><td>" + product.getProductID() + "</td><td>" + product.getProductDetails() + "</td></tr>");
            out.println("</table>");
        } else {
            out.println("<h1>No product with that ID exists</h1>");
        }
    }

}
