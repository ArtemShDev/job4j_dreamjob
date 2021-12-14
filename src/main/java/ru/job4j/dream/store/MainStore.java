package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {

    public static void main(String[] args) {
        int lastId = 0;
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job"));
        for (Post post : store.findAllPosts()) {
            lastId = post.getId();
            System.out.println(lastId + " " + post.getName());
        }
        Post post = store.findById(lastId);
        post.setName(post.getName() + " +++ ");
        store.save(post);
        store.save(new Candidate(0, "Candidate"));
        for (Candidate candidate : store.findAllCandidates()) {
            lastId = candidate.getId();
            System.out.println(lastId + " " + candidate.getName());
        }
        Candidate candidate = store.findByIdCandidate(lastId);
        candidate.setName("Mike");
        store.save(candidate);
    }
}