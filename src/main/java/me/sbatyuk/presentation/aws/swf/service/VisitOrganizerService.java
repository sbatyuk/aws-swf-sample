package me.sbatyuk.presentation.aws.swf.service;

import com.amazonaws.services.simpleworkflow.flow.annotations.Execute;
import com.amazonaws.services.simpleworkflow.flow.annotations.Workflow;
import com.amazonaws.services.simpleworkflow.flow.annotations.WorkflowRegistrationOptions;

@Workflow
@WorkflowRegistrationOptions(
    defaultExecutionStartToCloseTimeoutSeconds = 60)
public interface VisitOrganizerService {

  @Execute(version = "1.0")
  void prepareForJEEConf(String name, String email);

}
