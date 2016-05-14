package me.sbatyuk.presentation.aws.swf;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import me.sbatyuk.presentation.aws.swf.service.VisitOrganizerServiceClientExternalFactoryImpl;

public class SWFApp {

  public static void main(String[] args) {
    AmazonSimpleWorkflowClient swfClient =
        new AmazonSimpleWorkflowClient(new ProfileCredentialsProvider("JEEConf"));
    swfClient.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));

    VisitOrganizerServiceClientExternalFactoryImpl clientFactory =
        new VisitOrganizerServiceClientExternalFactoryImpl(swfClient, "JEEConf");

    clientFactory.getClient().prepareForJEEConf("Serhiy", "serhiy@lohika.com");
  }

}
