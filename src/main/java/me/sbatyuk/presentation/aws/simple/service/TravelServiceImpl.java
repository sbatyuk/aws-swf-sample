package me.sbatyuk.presentation.aws.simple.service;

import java.io.File;

public class TravelServiceImpl implements TravelService {

  @Override
  public int bookHotel(String name) {
    System.out.println("Booking hotel...");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // ignore
    }

    System.out.println("Booked hotel for " + name + '\n');
    return 2;
  }

  @Override
  public int bookTrainTickets(String name) {
    System.out.println("Booking train tickets...");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // ignore
    }

    checkFileExists();

    System.out.println("Booked train tickets for " + name + '\n');
    return 3;
  }

  private void checkFileExists() {
    File file = new File(System.getProperty("user.home"), "demo/swf");
    if (!file.exists()) {
      throw new RuntimeException("File does not exist!");
    }
  }

}
