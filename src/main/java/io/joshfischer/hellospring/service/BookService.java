package io.joshfischer.hellospring.service;

import static com.google.common.base.Preconditions.checkArgument;

import io.joshfischer.hellospring.domain.BookDetailResponse;
import io.joshfischer.hellospring.error.ResourceNotFoundException;
import io.joshfischer.hellospring.mapper.BookDetailResponseMapper;
import io.joshfischer.hellospring.repository.BookEntityRepository;
import io.joshfischer.hellospring.validator.AttributeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

  @Autowired private AttributeValidator attributeValidator;
  @Autowired private BookEntityRepository bookRepository;
  @Autowired private BookDetailResponseMapper responseMapper;

  private static final Logger logger = LoggerFactory.getLogger(BookService.class);

  @Transactional(propagation = Propagation.SUPPORTS)
  public BookDetailResponse get(final String bookId) {

    checkArgument(attributeValidator.isUuid(bookId), "bookId must be a valid uuid");

    final var book =
        bookRepository
            .findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found for id supplied"));

    return responseMapper.map(book);
  }
}
