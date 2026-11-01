package com.example.hibernatedemo.service.impl;

import com.example.hibernatedemo.entity.Author;
import com.example.hibernatedemo.entity.Book;
import com.example.hibernatedemo.repository.AuthorRepository;
import com.example.hibernatedemo.service.PersistenceContextDemoService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PersistenceContextDemoServiceImpl implements PersistenceContextDemoService {

    private final EntityManager entityManager;
    private final AuthorRepository authorRepository;

    @Transactional
    public void demonstrateFirstLevelCache(UUID bookId) {
        Book book1 = entityManager.find(Book.class, bookId);
        Book book2 = entityManager.find(Book.class, bookId);

        System.out.println("Same instance? " + (book1 == book2));
    }

    @Transactional
    public void demonstrateDirtyChecking(UUID bookId, String newTitle) {
        Book book = entityManager.find(Book.class, bookId);
        book.setTitle(newTitle);
    }

    @Transactional
    public UUID demonstrateLifecycle(Author author) {
        entityManager.persist(author);
        return author.getId();
    }

    @Transactional
    public Author demonstrateMerge(UUID detachedId) {
        Author detachedAuthor = new Author();
        detachedAuthor.setId(detachedId);
        detachedAuthor.setName("Updated Name");

        Author managed = entityManager.merge(detachedAuthor);
        return managed;
    }

    @Transactional
    public void demonstrateLazyLoading(UUID bookId) {
        Book book = entityManager.find(Book.class, bookId);
        Author author = book.getAuthor();
        System.out.println(author.getClass().getName());
        String name = author.getName();
        System.out.println(name);
    }

    public void demonstrateRepositoryCallChain() {
        UUID id = UUID.fromString("0227f9a2-48d3-4fd9-bea8-02b32e1b4a2f");
        Author author = authorRepository.findById(id).get();
    }
}