package io.joshfischer.hellospring.domain;

public class ApiResponse {

  private String code;
  private String message;

  public ApiResponse() {
    super();
    this.code = "";
    this.message = "";
  }

  public ApiResponse(final String code, final String message) {
    this();
    this.setCode(code);
    this.setMessage(message);
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
