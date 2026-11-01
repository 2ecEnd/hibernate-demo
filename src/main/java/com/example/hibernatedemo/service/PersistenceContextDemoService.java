package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Author;

import java.util.UUID;

public interface PersistenceContextDemoService {

    void demonstrateFirstLevelCache(UUID bookId);

    void demonstrateDirtyChecking(UUID bookId, String newTitle);

    UUID demonstrateLifecycle(Author author);

    Author demonstrateMerge(UUID detachedId);

    void demonstrateLazyLoading(UUID bookId);

    void demonstrateRepositoryCallChain();
}
