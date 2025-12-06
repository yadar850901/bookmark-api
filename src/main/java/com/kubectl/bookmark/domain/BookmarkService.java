package com.kubectl.bookmark.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    public Bookmark createBookmark(BookmarkReq bookmarkReq) {
        Bookmark bookmark = new Bookmark();
        bookmark.setUrl(bookmarkReq.getUrl());
        bookmark.setTitle(bookmarkReq.getTitle());
        bookmark.setCreatedAt(java.time.Instant.now());
        return bookmarkRepository.save(bookmark);
    }

    @Transactional(readOnly = true)
    public BookmarksDto getAllBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        PageRequest pageRequest = PageRequest.of(pageNo, 2, Sort.Direction.DESC, "createdAt");
        return new BookmarksDto(bookmarkRepository.findAll(pageRequest));
    }

    @Transactional(readOnly = true)
    public BookmarksDto searchBookmarks(Integer page,String query) {
        int pageNo = page < 1 ? 0 : page - 1;
        PageRequest pageRequest = PageRequest.of(pageNo, 2, Sort.Direction.DESC, "createdAt");
        return new BookmarksDto(bookmarkRepository.findByTitleContainingIgnoreCase(query,pageRequest));
    }

}
