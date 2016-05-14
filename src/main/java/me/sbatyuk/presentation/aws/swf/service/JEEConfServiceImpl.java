package me.sbatyuk.presentation.aws.swf.service;

public class JEEConfServiceImpl implements JEEConfService {

  @Override
  public int buyTicket(String name) {
    System.out.println("Buying JEEConf ticket...");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      // ignore
    }

    System.out.println("Bought JEEConf ticket for " + name + '\n');
    return 1;
  }

}
