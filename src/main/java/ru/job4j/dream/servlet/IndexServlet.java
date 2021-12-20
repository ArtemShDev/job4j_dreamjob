package ru.job4j.dream.servlet;

import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", DbStore.instOf().findAllCandidatesForToday());
        req.setAttribute("posts", new ArrayList<>(DbStore.instOf().findAllPostsForToday()));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}