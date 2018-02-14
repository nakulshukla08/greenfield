package com.db.awmd.challenge.exception;

public class DuplicateAccountIdException extends RuntimeException {

  public DuplicateAccountIdException(String message) {
    super(message);
  }
}
