package controller;

import entity.ProductsEntity;
import repository.ProductsRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int productID = Integer.parseInt(request.getParameter("productID"));
        String productDescription = request.getParameter("productDetails");
        if (ProductsRepository.productExists(productID)) {
            ProductsRepository.updateProduct(productID,productDescription);
        } else {
            ProductsRepository.addProduct(productID,productDescription);
        }
        for (ProductsEntity product: ProductsRepository.getAllProducts()){
            out.println("<table>");
            out.println("<tr><th>Product ID</th><th>Product Details</th></tr>");
            out.println("<tr><td>" + product.getId() + "</td><td>" + product.getDetails() + "</td></tr>");
            out.println("</table>");
        }
    }
}
