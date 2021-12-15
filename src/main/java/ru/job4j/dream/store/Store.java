package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    Post findById(int id);

    void save(Candidate candidate);

    Candidate findByIdCandidate(int id);

    boolean deleteCandidate(int id);

    boolean deletePost(int id);

    User findByEmail(String email);

    boolean addUser(User user);

    boolean checkUser(User user);
}