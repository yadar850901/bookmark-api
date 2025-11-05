package com.kubectl.bookmark.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@Data
public class Bookmark {

    public Bookmark(Long id, String url, String title, Instant createdAt) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.createdAt = createdAt;
    }
    public Bookmark() {
    }

    @Id
    @SequenceGenerator(name = "bookmark_seq_gen", sequenceName = "bookmark_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmark_seq_gen")
    private Long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Instant createdAt;


}