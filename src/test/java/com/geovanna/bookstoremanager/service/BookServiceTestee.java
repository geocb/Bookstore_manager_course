package com.geovanna.bookstoremanager.service;

import com.geovanna.bookstoremanager.dto.AuthorDTO;
import com.geovanna.bookstoremanager.dto.BookDTO;
import com.geovanna.bookstoremanager.dto.MessageResponseDTO;
import com.geovanna.bookstoremanager.entity.Book;
import com.geovanna.bookstoremanager.mapper.BookMapper;
import com.geovanna.bookstoremanager.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        when(bookMapper.toModel(any())).thenReturn(new Book(Long.valueOf(1), "name", Integer.valueOf(0), Integer.valueOf(0), "isbn", "publisherName", null));

        MessageResponseDTO result = bookService.create(new BookDTO(Long.valueOf(1), "name", Integer.valueOf(0), Integer.valueOf(0), "isbn", "publisherName", new AuthorDTO(Long.valueOf(1), "name", Integer.valueOf(0))));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme