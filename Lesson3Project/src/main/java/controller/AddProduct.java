package controller;

import repository.ProductsRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productDescription = request.getParameter("productDetails");
        ProductsRepository.addProduct(productID, productDescription);


    }
}
