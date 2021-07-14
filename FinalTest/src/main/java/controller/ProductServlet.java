package controller;

import model.bean.Category;
import model.bean.Product;
import model.repository.CRUDRepository;
import model.repository.impl.CategoryRepositoryImpl;
import model.repository.impl.ProductRepositoryImpl;
import model.service.CRUDService;
import model.service.impl.CategoryServiceImpl;
import model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "products")
public class ProductServlet extends HttpServlet {

    CRUDRepository<Product> productRepository = new ProductRepositoryImpl();
    CRUDRepository<Category> categoryRepository = new CategoryRepositoryImpl();
    CRUDService<Product> productService = new ProductServiceImpl();
    CRUDService<Category> categoryService = new CategoryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionClient = request.getParameter("actionClient");

        if (actionClient == null) {
            actionClient = "";
        }

        loadList(request, response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productListServlet", this.productService.findAll());
        request.setAttribute("categoryListServlet", this.categoryService.findAll());
        request.getRequestDispatcher("view/web/list_student.jsp").forward(request, response);
    }
}
