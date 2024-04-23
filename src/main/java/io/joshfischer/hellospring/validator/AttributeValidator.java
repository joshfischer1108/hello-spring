package io.joshfischer.hellospring.validator;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class AttributeValidator {

  public boolean isUuid(String uuid) {
    if (StringUtils.isBlank(uuid)) {
      return false;
    } else {
      try {
        UUID.fromString(uuid);
        return true;
      } catch (IllegalArgumentException var3) {
        return false;
      }
    }
  }
}
