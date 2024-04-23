package io.joshfischer.hellospring.repository;

import io.joshfischer.hellospring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity, String> {
  // empty on purpose
}
