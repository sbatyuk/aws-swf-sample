package me.sbatyuk.presentation.aws.simple.service;

public class VisitOrganizerServiceImpl implements VisitOrganizerService {

  private final JEEConfService jeeConfService = new JEEConfServiceImpl();
  private final TravelService travelService = new TravelServiceImpl();

  @Override
  public void prepareForJEEConf(String name, String email) {
    int ticket = jeeConfService.buyTicket(name);
    int hotel = travelService.bookHotel(name);
    int train = travelService.bookTrainTickets(name);

    sendConfirmationEmail(email, ticket, hotel, train);
  }

  private void sendConfirmationEmail(String email, int ticket, int hotel,
                                     int train) {

    System.out.println("Sent email to " + email);
    System.out.println("JEEConf ticket: #" + ticket);
    System.out.println("Hotel booking: #" + hotel);
    System.out.println("Train ticket: #" + train);
  }


}
