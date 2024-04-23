package io.joshfischer.hellospring.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import io.joshfischer.hellospring.entity.BookEntity;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookDetailResponseMapperTest {

  private BookDetailResponseMapper subject;

  @BeforeEach
  public void setUpForEachTestCase() {
    subject = new BookDetailResponseMapper();
  }

  @Test
  public void map_AllGood_BehavesAsExpected() {
    final var id = "book id";
    final var title = "the book title";
    final var created = new Date();
    final var entity = new BookEntity();
    entity.setId(id);
    entity.setTitle(title);
    entity.setCreated(created);

    final var response = subject.map(entity);

    assertThat(response.getId(), is(equalTo(id)));
    assertThat(response.getTitle(), is(equalTo(title)));
    assertThat(response.getId(), is(equalTo(id)));
  }
}
