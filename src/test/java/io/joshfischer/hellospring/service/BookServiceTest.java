package io.joshfischer.hellospring.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.joshfischer.hellospring.entity.BookEntity;
import io.joshfischer.hellospring.error.ResourceNotFoundException;
import io.joshfischer.hellospring.mapper.BookDetailResponseMapper;
import io.joshfischer.hellospring.repository.BookEntityRepository;
import io.joshfischer.hellospring.validator.AttributeValidator;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
  @Mock private AttributeValidator mockAttributeValidator;
  @Mock private BookEntityRepository mockBookRepository;
  @Mock private BookDetailResponseMapper mockResponseMapper;
  @InjectMocks private BookService subject;

  @AfterEach
  public void ensureNoUnexpectedMockInteractions() {
    Mockito.verifyNoMoreInteractions(
        mockAttributeValidator, mockBookRepository, mockResponseMapper);
  }

  @Test
  public void get_AllGood_BehavesAsExpected() {
    final var bookId = "the book id";
    final var entity = new BookEntity();

    when(mockAttributeValidator.isUuid(same(bookId))).thenReturn(true);
    when(mockBookRepository.findById(same(bookId))).thenReturn(Optional.of(entity));

    subject.get(bookId);

    verify(mockAttributeValidator).isUuid(same(bookId));
    verify(mockBookRepository).findById(same(bookId));
    verify(mockResponseMapper).map(same(entity));
  }

  @Test
  public void get_InvalidUUID_ExceptionThrown() {

    final var invalidUUID = "invalid uuid";

    when(mockAttributeValidator.isUuid(same(invalidUUID))).thenCallRealMethod();

    final var exception =
        assertThrows(IllegalArgumentException.class, () -> subject.get(invalidUUID));

    assertThat(exception.getMessage(), is(equalTo("bookId must be a valid uuid")));

    verify(mockAttributeValidator).isUuid(same(invalidUUID));
  }

  @Test
  public void get_BookNotFoundForId_ExceptionThrown() {
    final var uuid = "uuid";

    when(mockAttributeValidator.isUuid(same(uuid))).thenReturn(true);
    when(mockBookRepository.findById(same(uuid))).thenReturn(Optional.empty());

    final var exception = assertThrows(ResourceNotFoundException.class, () -> subject.get(uuid));

    assertThat(exception.getMessage(), is(equalTo("Book not found for id supplied")));

    verify(mockAttributeValidator).isUuid(same(uuid));
    verify(mockBookRepository).findById(same(uuid));
  }
}
