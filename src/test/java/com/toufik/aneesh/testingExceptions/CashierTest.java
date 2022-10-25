package com.toufik.aneesh.testingExceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

  @BeforeEach
  void setUp() {
  }

  private static List<String> testArguments(){
    return List.of(
        "USD",
        "CD",
        "LIRA",
        "MDH");
  }

  private static List<Integer> testValues(){
    return List.of(
        -10,
        -3,
        -34,
        -54);
  }

  @ParameterizedTest
  @MethodSource("testArguments")
  void validateTransaction(String valuta) {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      Cashier.validateTransaction(valuta, 10);
    });
    String expectedMessage = " not within accepted currencies list.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));

  }

  @ParameterizedTest
  @MethodSource("testValues")
  void validateTransactionWithValues(double valuta) {
    RuntimeException exception = assertThrows(InvalidTransactionAmountException.class, () -> {
      Cashier.validateTransaction("EUR", valuta);
    });
    String expectedMessage = "Transaction amount must be greater than 0";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }
}