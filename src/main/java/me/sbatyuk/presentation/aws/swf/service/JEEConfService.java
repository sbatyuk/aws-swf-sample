package me.sbatyuk.presentation.aws.swf.service;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version = "1.0")
@ActivityRegistrationOptions(
    defaultTaskScheduleToStartTimeoutSeconds = 10,
    defaultTaskStartToCloseTimeoutSeconds = 30)
public interface JEEConfService {

  int buyTicket(String name);

}
