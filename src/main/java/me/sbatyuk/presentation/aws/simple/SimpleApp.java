package me.sbatyuk.presentation.aws.simple;

import me.sbatyuk.presentation.aws.simple.service.VisitOrganizerService;
import me.sbatyuk.presentation.aws.simple.service.VisitOrganizerServiceImpl;

public class SimpleApp {

  public static void main(String[] args) {
    VisitOrganizerService service = new VisitOrganizerServiceImpl();
    service.prepareForJEEConf("Serhiy", "serhiy@lohika.com");
  }

}
