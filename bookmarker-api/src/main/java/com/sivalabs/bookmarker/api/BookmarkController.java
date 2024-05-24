package com.sivalabs.bookmarker.api;

import com.sivalabs.bookmarker.domain.BookmarkService;
import com.sivalabs.bookmarker.domain.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService service;

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "query", required = false) String query){
        if(query == null || query.trim().isEmpty()){
            return service.getBookmarks(page);
        }
        return service.searchBookmarks(query, page);
    }


}
