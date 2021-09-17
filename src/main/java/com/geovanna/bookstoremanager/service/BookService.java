package com.geovanna.bookstoremanager.service;

import com.geovanna.bookstoremanager.dto.MessageResponseDTO;
import com.geovanna.bookstoremanager.entity.Book;
import com.geovanna.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book savedbook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedbook.getId())
                .build();
    }
}
