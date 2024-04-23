package io.joshfischer.hellospring.controller;

import io.joshfischer.hellospring.domain.BookDetailResponse;
import io.joshfischer.hellospring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BookController {

  @Autowired private BookService bookService;

  @GetMapping(value = "/books/{book-id}", produces = "application/json")
  public BookDetailResponse get(@PathVariable(value = "book-id") final String bookId) {
    return bookService.get(bookId);
  }
}
