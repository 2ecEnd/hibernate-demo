package com.example.hibernatedemo.controller;

import com.example.hibernatedemo.dto.DirtyCheckingDto;
import com.example.hibernatedemo.dto.BookIdDto;
import com.example.hibernatedemo.dto.LifecycleDto;
import com.example.hibernatedemo.service.PersistenceContextDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersistenceContextDemoController {

    private final PersistenceContextDemoService persistenceContextDemoController;

    @GetMapping("/firstLevelCache")
    public ResponseEntity<Void> demonstrateFirstLevelCache(@RequestBody BookIdDto request) {
        persistenceContextDemoController.demonstrateFirstLevelCache(request.getBookId());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/dirtyChecking")
    public ResponseEntity<Void> demonstrateDirtyChecking(@RequestBody DirtyCheckingDto request) {
        persistenceContextDemoController.demonstrateDirtyChecking(request.getBookId(), request.getNewTitle());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/lifecycle")
    public ResponseEntity<Void> demonstrateLifecycle(@RequestBody LifecycleDto request) {
        persistenceContextDemoController.demonstrateLifecycle(request.getAuthor());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/merge")
    public ResponseEntity<Void> demonstrateMerge(@RequestBody BookIdDto request) {
        persistenceContextDemoController.demonstrateMerge(request.getBookId());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/lazyLoading")
    public ResponseEntity<Void> demonstrateLazyLoading(@RequestBody BookIdDto request) {
        persistenceContextDemoController.demonstrateLazyLoading(request.getBookId());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/repositoryCallChain")
    public ResponseEntity<Void> demonstrateRepositoryCallChain() {
        persistenceContextDemoController.demonstrateRepositoryCallChain();

        return ResponseEntity.ok().build();
    }
}
