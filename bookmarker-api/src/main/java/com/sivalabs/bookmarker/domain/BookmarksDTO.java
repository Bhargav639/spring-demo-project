package com.sivalabs.bookmarker.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class BookmarksDTO {

    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookmarksDTO(Page<BookmarkDTO> bookmarksPage){
        this.setData(bookmarksPage.getContent());
        this.setTotalElements(bookmarksPage.getTotalElements());
        this.setTotalPages(bookmarksPage.getTotalPages());
        this.setCurrentPage(bookmarksPage.getNumber()+1);
        this.setFirst(bookmarksPage.isFirst());
        this.setLast(bookmarksPage.isLast());
        this.setHasNext(bookmarksPage.hasNext());
        this.setHasPrevious(bookmarksPage.hasPrevious());
    }
}
