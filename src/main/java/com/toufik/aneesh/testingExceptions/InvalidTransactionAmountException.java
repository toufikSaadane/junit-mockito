package com.toufik.aneesh.testingExceptions;

public class InvalidTransactionAmountException extends RuntimeException{

  public InvalidTransactionAmountException(String message) {
    super(message);
  }
}
