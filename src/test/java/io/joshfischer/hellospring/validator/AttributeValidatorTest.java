package io.joshfischer.hellospring.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttributeValidatorTest {

  private AttributeValidator subject;

  @BeforeEach
  public void setUpForEachTestCase() {
    subject = new AttributeValidator();
  }

  @Test
  public void isUuid_AllGood_BehavesAsExpected() {
    final var candidate = UUID.randomUUID().toString();

    assertTrue(subject.isUuid(candidate));
  }

  @Test
  public void isUuid_InvalidUuid_ReturnsFalse() {
    final var candidate = "not a uuid";

    assertFalse(subject.isUuid(candidate));
  }
}
