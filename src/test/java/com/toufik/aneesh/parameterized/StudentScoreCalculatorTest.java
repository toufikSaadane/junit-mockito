package com.toufik.aneesh.parameterized;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class StudentScoreCalculatorTest {

  StudentScoreCalculator studentScoreCalculator;

  @BeforeEach
  void setUp() {
   studentScoreCalculator = new StudentScoreCalculator();
  }

  @Test
  void studentScoreCalculatorRegular() {
    studentScoreCalculator.calculateSATScore(50, 50);
    assertEquals(2500, studentScoreCalculator.getSatScore());
  }

  @Test
  void studentScoreCalculatorNegative() {
    studentScoreCalculator.calculateSATScore(50, -5);
    assertEquals(-1, studentScoreCalculator.getSatScore());
  }

  @Test
  void studentScoreCalculatorTooBig() {
    studentScoreCalculator.calculateSATScore(250, 205);
    assertEquals(-1, studentScoreCalculator.getSatScore());
  }

  @Test
  public void studentScoreCalculatorBothNegative(){
    studentScoreCalculator.calculateSATScore(-1, -1);
    assertEquals(-1, studentScoreCalculator.getSatScore());

  }

  @Test
  public void studentScoreCalculatorMathsHigh(){
    studentScoreCalculator.calculateSATScore(102, 50);
    assertEquals(-1, studentScoreCalculator.getSatScore());

  }

  @Test
  public void studentScoreCalculatorLiteracyHigh(){
    studentScoreCalculator.calculateSATScore(50, 150);
    assertEquals(-1, studentScoreCalculator.getSatScore());

  }

  @Test
  public void studentScoreCalculatorBothHigh(){
    studentScoreCalculator.calculateSATScore(150, 150);
    assertEquals(-1, studentScoreCalculator.getSatScore());

  }

}