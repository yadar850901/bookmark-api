package com.kubectl.bookmark.api;

import com.kubectl.bookmark.domain.Bookmark;
import com.kubectl.bookmark.domain.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer  implements CommandLineRunner {
    @Autowired
    private BookmarkRepository bookmarkRepo;
    @Override
    public void run(String... args) throws Exception {
        bookmarkRepo.save(new Bookmark(null, "https://example.com", "Example", java.time.Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "https://spring.io", "Spring", java.time.Instant.now()));
        bookmarkRepo.save(new Bookmark(null, "https://github.com", "GitHub", java.time.Instant.now()));
    }
}
