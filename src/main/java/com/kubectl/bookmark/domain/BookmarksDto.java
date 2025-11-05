package com.kubectl.bookmark.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarksDto {
    private List<Bookmark> data;
    private int totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;
    public BookmarksDto(Page<Bookmark> bookmarkPage) {
        this.data = bookmarkPage.getContent();
        this.totalElements = (int) bookmarkPage.getTotalElements();
        this.totalPages = bookmarkPage.getTotalPages();
        this.currentPage = bookmarkPage.getNumber() + 1; // Page number is zero-based
        this.isFirst = bookmarkPage.isFirst();
        this.isLast = bookmarkPage.isLast();
        this.hasNext = bookmarkPage.hasNext();
        this.hasPrevious = bookmarkPage.hasPrevious();
    }
}
