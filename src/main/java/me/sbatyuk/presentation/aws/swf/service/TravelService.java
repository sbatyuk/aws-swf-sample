package me.sbatyuk.presentation.aws.swf.service;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;
import com.amazonaws.services.simpleworkflow.flow.annotations.ExponentialRetry;

@Activities(version = "1.0")
@ActivityRegistrationOptions(
    defaultTaskScheduleToStartTimeoutSeconds = 10,
    defaultTaskStartToCloseTimeoutSeconds = 30)
public interface TravelService {

  int bookHotel(String name);

  @ExponentialRetry(initialRetryIntervalSeconds = 10, backoffCoefficient = 1)
  int bookTrainTickets(String name);

}
