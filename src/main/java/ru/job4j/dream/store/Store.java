package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final static AtomicInteger POST_ID = new AtomicInteger(4);

    private final static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private Store() {
        Calendar monthAgo = Calendar.getInstance();
        monthAgo.roll(Calendar.MONTH, -1);
        Calendar twoMonthAgo = Calendar.getInstance();
        twoMonthAgo.roll(Calendar.MONTH, -2);
        posts.put(1, new Post(1, "Junior Java Job", "Very good job", Calendar.getInstance()));
        posts.put(2, new Post(2, "Middle Java Job", "Very very good job", monthAgo));
        posts.put(3, new Post(3, "Senior Java Job", "Very very very good job", twoMonthAgo));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public void save(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        candidate.setId(CANDIDATE_ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }
}