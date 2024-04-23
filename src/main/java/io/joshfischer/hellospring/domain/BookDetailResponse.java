package io.joshfischer.hellospring.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class BookDetailResponse implements Serializable {
  @Serial private static final long serialVersionUID = -3145097604971461221L;

  public static final String MEDIA_TYPE =
      "application/vnd.hello-spring.book-detail-response.1+json";

  private final String id;

  private final String title;

  private final Date created;

  private BookDetailResponse(final String id, final String title, final Date created) {
    this.id = id;
    this.title = title;
    this.created = created;
  }

  public static BookDetailResponse of(final String id, final String name, final Date created) {
    return new BookDetailResponse(id, name, created);
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Date getCreated() {
    return created;
  }
}
