package com.kubectl.bookmark.api;

import com.kubectl.bookmark.domain.Bookmark;
import com.kubectl.bookmark.domain.BookmarkReq;
import com.kubectl.bookmark.domain.BookmarkService;
import com.kubectl.bookmark.domain.BookmarksDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping
    public BookmarksDto getAllBookmarks(@RequestParam(name= "page",defaultValue = "1") Integer page,
                                        @RequestParam(name= "query",defaultValue = "") String query) {
        if(query == null || query.trim().length()==0) {
            return bookmarkService.getAllBookmarks(page);
        }
        return bookmarkService.searchBookmarks(page, query);
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Bookmark createBookmark(@RequestBody @Valid BookmarkReq bookmark) {
        return bookmarkService.createBookmark(bookmark);
    }
}
