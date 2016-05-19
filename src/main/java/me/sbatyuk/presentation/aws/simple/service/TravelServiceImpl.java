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

    checkErrorFile();

    System.out.println("Booked train tickets for " + name + '\n');
    return 3;
  }

  private void checkErrorFile() {
    File file = new File(System.getProperty("user.home"), "swf/error");
    if (file.exists()) {
      throw new RuntimeException("We've got an error!");
    }
  }

}
