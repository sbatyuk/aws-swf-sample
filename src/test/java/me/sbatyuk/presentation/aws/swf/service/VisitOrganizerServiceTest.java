package me.sbatyuk.presentation.aws.swf.service;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.junit.AsyncAssert;
import com.amazonaws.services.simpleworkflow.flow.junit.FlowBlockJUnit4ClassRunner;
import com.amazonaws.services.simpleworkflow.flow.junit.WorkflowTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(FlowBlockJUnit4ClassRunner.class)
public class VisitOrganizerServiceTest {

  @Rule
  public WorkflowTest workflowTest = new WorkflowTest();

  private List<String> trace = new ArrayList<>();

  private VisitOrganizerServiceClientFactory factory = new
      VisitOrganizerServiceClientFactoryImpl();

  @Before
  public void setUp() {
    JEEConfService jeeConfService = new JEEConfService() {

      @Override
      public int buyTicket(String name) {
        trace.add("buyTicket-" + name);
        return 1;
      }
    };

    TravelService travelService = new TravelService() {

      @Override
      public int bookHotel(String name) {
        trace.add("bookHotel-" + name);
        return 2;
      }

      @Override
      public int bookTrainTickets(String name) {
        trace.add("bookTrainTickets-" + name);
        return 3;
      }
    };

    workflowTest.addActivitiesImplementation(jeeConfService);
    workflowTest.addActivitiesImplementation(travelService);
    workflowTest.addWorkflowImplementationType(VisitOrganizerServiceImpl.class);
  }

  @After
  public void tearDown() {
    trace.clear();
  }

  @Test
  public void testPrepareForJEEConf() {
    VisitOrganizerServiceClient client = factory.getClient();
    Promise<Void> prepared =
        client.prepareForJEEConf("Serhiy", "serhiy@lohika.com");
    List<String> expected = new ArrayList<>();
    expected.add("buyTicket-Serhiy");
    expected.add("bookHotel-Serhiy");
    expected.add("bookTrainTickets-Serhiy");
    AsyncAssert.assertEqualsWaitFor(expected, trace, prepared);
  }
}
