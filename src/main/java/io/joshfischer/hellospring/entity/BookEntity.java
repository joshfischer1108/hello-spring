package io.joshfischer.hellospring.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "book_id"))
@Table(name = "books")
public class BookEntity extends AbstractEntity {
  @Serial private static final long serialVersionUID = 2216409253670389126L;

  @Column(name = "title", length = 255)
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }
}
