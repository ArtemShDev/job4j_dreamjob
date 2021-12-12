package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        Calendar monthAgo = Calendar.getInstance();
        monthAgo.roll(Calendar.MONTH, -1);
        Calendar twoMonthAgo = Calendar.getInstance();
        twoMonthAgo.roll(Calendar.MONTH, -2);
        posts.put(1, new Post(1, "Junior Java Job", "Very good job", Calendar.getInstance()));
        posts.put(2, new Post(2, "Middle Java Job", "Very very good job", monthAgo));
        posts.put(3, new Post(3, "Senior Java Job", "Very very very good job", twoMonthAgo));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}