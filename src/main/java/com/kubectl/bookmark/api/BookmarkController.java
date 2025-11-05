package com.kubectl.bookmark.api;

import com.kubectl.bookmark.domain.Bookmark;
import com.kubectl.bookmark.domain.BookmarkService;
import com.kubectl.bookmark.domain.BookmarksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDto getAllBookmarks(@RequestParam(name= "page",defaultValue = "1") Integer page) {
        return bookmarkService.getAllBookmarks(page);
    }
}
