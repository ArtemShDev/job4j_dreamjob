package ru.job4j.dream.servlets;

import ru.job4j.dream.Config;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class DeleteCandidateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        MemStore.instOf().delete(Integer.parseInt(
                req.getParameter("id")));
        File photo = new File(Config.getCfg().getProperty("dir") + req.getParameter("id"));
        photo.delete();
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}