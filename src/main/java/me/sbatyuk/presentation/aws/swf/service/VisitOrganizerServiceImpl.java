package me.sbatyuk.presentation.aws.swf.service;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class VisitOrganizerServiceImpl implements VisitOrganizerService {

  private final JEEConfServiceClient jeeConfService = new JEEConfServiceClientImpl();
  private final TravelServiceClient travelService = new TravelServiceClientImpl();

  @Override
  public void prepareForJEEConf(String name, String email) {
    Promise<Integer> ticket = jeeConfService.buyTicket(name);
    Promise<Integer> hotel = travelService.bookHotel(name, ticket);
    Promise<Integer> train = travelService.bookTrainTickets(name, ticket);

    sendConfirmationEmail(email, ticket, hotel, train);
  }

  @Asynchronous
  private void sendConfirmationEmail(String email,
                                     Promise<Integer> ticket,
                                     Promise<Integer> hotel,
                                     Promise<Integer> train) {

    System.out.println("Sent email to " + email);
    System.out.println("JEEConf ticket: #" + ticket.get());
    System.out.println("Hotel booking: #" + hotel.get());
    System.out.println("Train ticket: #" + train.get());
  }


}
