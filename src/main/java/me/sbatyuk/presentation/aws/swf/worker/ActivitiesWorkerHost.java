package me.sbatyuk.presentation.aws.swf.worker;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import me.sbatyuk.presentation.aws.swf.service.JEEConfServiceImpl;
import me.sbatyuk.presentation.aws.swf.service.TravelServiceImpl;

public class ActivitiesWorkerHost {

  public static void main(String[] args) throws Exception {
    AmazonSimpleWorkflowClient swfClient =
        new AmazonSimpleWorkflowClient(new ProfileCredentialsProvider("JEEConf"));
    swfClient.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));

    ActivityWorker activityWorker =
        new ActivityWorker(swfClient, "JEEConf", "preparation");
    activityWorker.addActivitiesImplementation(new JEEConfServiceImpl());
    activityWorker.addActivitiesImplementation(new TravelServiceImpl());
    activityWorker.start();
  }

}
