package io.joshfischer.hellospring.mapper;

import io.joshfischer.hellospring.domain.BookDetailResponse;
import io.joshfischer.hellospring.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookDetailResponseMapper {

  public BookDetailResponse map(final BookEntity entity) {
    return BookDetailResponse.of(entity.getId(), entity.getTitle(), entity.getCreated());
  }
}
