package com.toufik.aneesh.parameterized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

class StudentScoreCalculatorTestParametrized {

  private static Object[] testValues(){

    return new Object[]{
        new Object[]{50, 50,  2500},
        new Object[]{-10, 50, -1},
        new Object[]{50, -1, -1},
        new Object[]{-1, -1, -1},
        new Object[]{150, 50, -1},
        new Object[]{50, 150, -1},
        new Object[]{150, 150, -1},
        new Object[]{0, 0, 0},
        new Object[]{100, 100, 10000}
    };
  }

  @ParameterizedTest
  @MethodSource("testValues")
  public void studentScoreCalculator(int mathsScore, int literacyScore, int expectedScore){

    StudentScoreCalculator sc = new StudentScoreCalculator();
    sc.calculateSATScore(mathsScore, literacyScore);
    assertEquals(expectedScore, sc.getSatScore());
  }

}