package com.sivalabs.bookmarker.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    @NotEmpty(message = "Please enter Title")
    private String title;
    @NotEmpty(message = "Please enter URL")
    private String url;

}
