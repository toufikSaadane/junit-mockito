package com.toufik.aneesh.domain;

import com.toufik.aneesh.assertByJunit.Player;
import com.toufik.aneesh.assertByJunit.PlayerStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsTest {

  Player playerUnderThirty;
  Player playerAboveThirty;
  private PlayerStatistics statisticsOfPatrickUnderThirty;
  private PlayerStatistics statisticsOfPatrickAboveThirty;

  @BeforeEach
  void setUp() {
    playerUnderThirty = new Player("toufik", 27);
    playerAboveThirty = new Player("toufik", 47);
    statisticsOfPatrickUnderThirty = new PlayerStatistics(playerUnderThirty, 3, 3);
    statisticsOfPatrickAboveThirty = new PlayerStatistics(playerAboveThirty, 3, 3);
  }

  @Test
  public void playerNameEqual() {
    Player player = new Player("toufik", 37);
    assertNotNull(playerUnderThirty);
    assertNotNull(player);
    assertEquals(player, playerUnderThirty);
    assertThat(player).isInstanceOf(Player.class);
    assertThat(player).isEqualTo(playerUnderThirty);
  }

  @Test
  public void playerNamesNotEqual() {
    System.out.println("test 2");
    Player player2 = new Player("Kalvin", 25);
    assertNotEquals(playerUnderThirty, player2);
    assertThat(player2).isNotEqualTo(playerUnderThirty);
  }

  @Test
  public void youngerPlayerSame() {
    System.out.println("test 3");
    Player player2 = new Player("Kalvin", 25);
    assertSame(player2, PlayerStatistics.getYoungerPlayer(player2, playerUnderThirty));
    assertThat(player2).isSameAs(PlayerStatistics.getYoungerPlayer(player2, playerUnderThirty));
  }

  @Test
  public void underThirtyTrue(){
    System.out.println("test 4");
    assertTrue(statisticsOfPatrickUnderThirty.underThirty());
    assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    assertThat(statisticsOfPatrickUnderThirty.underThirty()).isEqualTo(true);
  }

  @Test
  public void playerUnderThirtyFalse(){
    assertFalse(statisticsOfPatrickAboveThirty.underThirty());
    assertThat(statisticsOfPatrickAboveThirty.underThirty()).isFalse();
    assertThat(statisticsOfPatrickAboveThirty.underThirty()).isEqualTo(false);
  }

  @Test
  public void csvReportsNull(){
    PlayerStatistics playerStatisticsNull = new PlayerStatistics(playerAboveThirty, 0, 0);
    assertThat(playerStatisticsNull.createCsvRecord()).isNull();
    assertNull(playerStatisticsNull.createCsvRecord());

  }

  @Test
  public void csvReportsNotNull(){
    PlayerStatistics playerStatisticsNull = new PlayerStatistics(playerAboveThirty, 8, 16);
    assertThat(playerStatisticsNull.createCsvRecord()).isNotNull();
    assertNotNull(playerStatisticsNull.createCsvRecord());

  }

  @Test
  public void getCsvStatus(){
    PlayerStatistics playerStatisticsNull = new PlayerStatistics(playerAboveThirty, 8, 16);
    Double[] doubleCsv = {2d, 0.5};
    assertArrayEquals(doubleCsv, playerStatisticsNull.createCsvRecord());
    assertThat(doubleCsv).hasSameElementsAs(Arrays.asList(playerStatisticsNull.createCsvRecord()));
    assertTrue(Arrays.deepEquals(doubleCsv, playerStatisticsNull.createCsvRecord()));
  }



}