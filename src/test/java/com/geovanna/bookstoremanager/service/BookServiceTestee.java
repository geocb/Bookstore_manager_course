package com.geovanna.bookstoremanager.service;

import com.geovanna.bookstoremanager.dto.AuthorDTO;
import com.geovanna.bookstoremanager.dto.BookDTO;
import com.geovanna.bookstoremanager.dto.MessageResponseDTO;
import com.geovanna.bookstoremanager.entity.Book;
import com.geovanna.bookstoremanager.exception.BookNotFoundException;
import com.geovanna.bookstoremanager.mapper.BookMapper;
import com.geovanna.bookstoremanager.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    BookMapper bookMapper;
    @InjectMocks
    BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        when(bookMapper.toModel(any())).thenReturn(new Book(1L, "name", 0, 0, "isbn", "publisherName", null));

        MessageResponseDTO result = bookService.create(new BookDTO(1L, "name", 0, 0, "isbn", "publisherName", new AuthorDTO(Long.valueOf(1), "name", Integer.valueOf(0))));
        Assertions.assertEquals(null, result);
    }
    @Test
    void whenGivesUnexistingIdThenNotFindThrowAnException() {
        long invalidId = 10L;

        when(bookRepository.findById(invalidId))
                .thenReturn(Optional.ofNullable(any(Book.class)));

        assertThrows(BookNotFoundException.class, () -> bookService.findById(invalidId));
    }
}
//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme