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
        Post post1 = new Post(0, "Java Job 1");
        Post post2 = new Post(0, "Java Job 2");
        Post post3 = new Post(0, "Java Job 3");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        store.save(post1);
        store.save(post2);
        store.save(post3);
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
        Candidate candidate1 = new Candidate(0, "New Candidate - Java Junior 1");
        Candidate candidate2 = new Candidate(0, "New Candidate - Java Junior 2");
        Candidate candidate3 = new Candidate(0, "New Candidate - Java Junior 3");
        candidates.add(candidate1);
        candidates.add(candidate2);
        candidates.add(candidate3);
        store.save(candidate1);
        store.save(candidate2);
        store.save(candidate3);
        assertThat(store.findAllCandidates(), is(candidates));
    }
}