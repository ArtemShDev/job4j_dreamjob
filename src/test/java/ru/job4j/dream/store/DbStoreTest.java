package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DbStoreTest {

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenModifyPost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        post.setName("TEST_NAME");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenFindByIdPost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb, is(post));
    }

    @Test
    public void whenfindAllPosts() {
        Store store = DbStore.instOf();
        for (Post post : store.findAllPosts()) {
            store.deletePost(post.getId());
        }
        Collection<Post> posts = new ArrayList<>();
        posts.add(new Post(0, "Java Job 1"));
        posts.add(new Post(0, "Java Job 2"));
        posts.add(new Post(0, "Java Job 3"));
        for (Post post : posts) {
            store.save(post);
        }
        assertThat(store.findAllPosts(), is(posts));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "New Candidate - Java Junior");
        store.save(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb, is(candidate));
    }

    @Test
    public void whenModifyCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "New Candidate - Java Junior");
        store.save(candidate);
        candidate.setName("TEST_NAME_FOR_CANDIDATE");
        store.save(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenFindByIdCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "New Candidate - Java Junior");
        store.save(candidate);
        Candidate candidateInDb = store.findByIdCandidate(candidate.getId());
        assertThat(candidateInDb, is(candidate));
    }

    @Test
    public void whenfindAllCandidates() {
        Store store = DbStore.instOf();
        for (Candidate candidate : store.findAllCandidates()) {
            store.deleteCandidate(candidate.getId());
        }
        Collection<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate(0, "New Candidate - Java Junior 1"));
        candidates.add(new Candidate(0, "New Candidate - Java Junior 2"));
        candidates.add(new Candidate(0, "New Candidate - Java Junior 3"));
        for (Candidate candidate : candidates) {
            store.save(candidate);
        }
        assertThat(store.findAllCandidates(), is(candidates));
    }
}