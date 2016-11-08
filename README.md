This is a sample [AWS Simple Workflow](https://aws.amazon.com/swf/) application that I used for demo purposes during [my talk at JEEConf 2016](http://jeeconf.com/program/aws-simple-workflow-distributed-out-of-the-box/).

The project actually contains 2 main classes: `SimpleApp` and `SWFApp`. The first one implements a synchronous conference booking workflow using plain Java. The second one, on the other hand, uses AWS SWF to seamlessly transform the app into a collection of asynchronous services that can run in a distributed fashion.

The goal of this sample is to show how easy it is to add AWS SWF into an existing app and get all the benefits (scalability, availability, etc.) of a distributed app.
