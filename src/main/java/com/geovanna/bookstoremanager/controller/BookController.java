package com.geovanna.bookstoremanager.controller;

import com.geovanna.bookstoremanager.dto.BookDTO;
import com.geovanna.bookstoremanager.dto.MessageResponseDTO;
import com.geovanna.bookstoremanager.entity.Book;
import com.geovanna.bookstoremanager.repository.BookRepository;
import com.geovanna.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }
}
