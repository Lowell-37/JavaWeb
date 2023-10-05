package com.lowell.fruit.servlets;

import com.lowell.fruit.dao.FruitDAO;
import com.lowell.fruit.dao.impl.FruitDAOImpl;
import com.lowell.fruit.myssm.myspringmvc.ViewBaseServlet;
import com.lowell.fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FruitDAO fruitDAO = new FruitDAOImpl();

        List<Fruit> fruitList = fruitDAO.getFruitList();
        HttpSession session = request.getSession();
        session.setAttribute("fruitList", fruitList);

        super.processTemplate("index", request, response);
    }
}
