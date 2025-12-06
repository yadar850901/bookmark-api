package com.kubectl.bookmark.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarkReq {
    @NotEmpty
    private String url;
    @NotEmpty
    private String title;
}
