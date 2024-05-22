package com.sivalabs.bookmarker.api;

import com.sivalabs.bookmarker.domain.Bookmark;
import com.sivalabs.bookmarker.domain.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
/*@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})*/
class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;

    private ArrayList<Bookmark> bookmarks;

    @Autowired
    BookmarkRepository bookmarkRepository;

    @BeforeEach
    void setUp(){
        bookmarkRepository.deleteAllInBatch();

        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null,"YouTube", "https://www.youtube.com", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,22,3,1",
            "2,22,3,2",
            "3,22,3,3"
    })
    void shouldGetBookmatks(int pageNo, int totalElements, int totalPges, int currentPage) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+pageNo)).andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPges)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)));

    }

}