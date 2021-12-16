package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CandidateServletTest {
    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("fio")).thenReturn("Test user");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findByIdCandidate(0);
        assertThat(candidate, nullValue());
    }

    @Test(expected = NumberFormatException.class)
    public void whenCreateCandidateFailed() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findByIdCandidate(0);
        assertThat(candidate, nullValue());
    }
}