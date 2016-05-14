package me.sbatyuk.presentation.aws.swf.worker;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import me.sbatyuk.presentation.aws.swf.service.VisitOrganizerServiceImpl;

public class WorkflowWorkerHost {

  public static void main(String[] args) throws Exception {
    AmazonSimpleWorkflowClient swfClient =
        new AmazonSimpleWorkflowClient(new ProfileCredentialsProvider("JEEConf"));
    swfClient.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));

    WorkflowWorker workflowWorker =
        new WorkflowWorker(swfClient, "JEEConf", "preparation");
    workflowWorker.addWorkflowImplementationType(VisitOrganizerServiceImpl.class);
    workflowWorker.start();
  }

}
