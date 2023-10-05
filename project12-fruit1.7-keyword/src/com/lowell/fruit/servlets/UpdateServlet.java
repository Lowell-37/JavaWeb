package com.lowell.fruit.servlets;

import com.lowell.fruit.dao.FruitDAO;
import com.lowell.fruit.dao.impl.FruitDAOImpl;
import com.lowell.fruit.myssm.myspringmvc.ViewBaseServlet;
import com.lowell.fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String fidStr = request.getParameter("fid");
        Integer fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));

//        super.processTemplate("index", request, response);
        response.sendRedirect("index");
    }
}
