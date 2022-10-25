package com.toufik.aneesh.mockitoWhen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingManagerTest {

  private BookingManager bookingManager;
  private HotelDao hotelDao;
  List<String> availableRooms;

  @BeforeEach
  void setUp() {
    hotelDao = mock(HotelDao.class);
    bookingManager = new BookingManager(hotelDao);
    availableRooms = List.of("Room-A");
  }

  @Test
  void checkRoomAvailability() throws SQLException {
    when(hotelDao.fetchAvailableRooms()).thenReturn(availableRooms);
    assertTrue(bookingManager.checkRoomAvailability("Room-A"));
    assertThat(bookingManager.checkRoomAvailability("Room-A")).isTrue();
  }

  @Test
  void roomAvailabilityFalse() throws SQLException {
    when(hotelDao.fetchAvailableRooms()).thenReturn(availableRooms);
    assertFalse(bookingManager.checkRoomAvailability("Room-B"));
    assertThat(bookingManager.checkRoomAvailability("Room-B")).isFalse();
  }
}