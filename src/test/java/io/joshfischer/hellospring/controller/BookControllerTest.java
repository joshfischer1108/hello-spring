package io.joshfischer.hellospring.controller;

import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;

import io.joshfischer.hellospring.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

  @Mock private BookService mockBookService;
  @InjectMocks private BookController subject;

  @AfterEach
  public void ensureNoUnexpectedMockInteractions() {
    Mockito.verifyNoMoreInteractions(mockBookService);
  }

  @Test
  public void get_AllGoodBehavesAsExpected() {
    String bookId = "the book id";

    subject.get(bookId);

    verify(mockBookService).get(same(bookId));
  }
}
