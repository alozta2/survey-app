# Survey App

### Description

Simple survey app using microservices architecture. You can add/edit/delete survey questions and answers using this backend application.

Structure as follows:

(ConfigService) -> Other services fetch their specific configurations from this service

(DiscoveryService) -> Allows other services to register themselves, so that they can be found in our setup, uses Netflix Eureka. Stats available in http://localhost:4061/

(GatewayService) -> Provides more realistic approach to microservices architecture by limiting actual services to talking clients directly. client <-> gateway <-> service. For demo purposes services are also directly accessible

(QuestionService) -> Service to query question related stuff

(AnswerService) -> Service to query answer related stuff

### How structures interact with each other

Each service fetches configurations from (ConfigService) in init stage.

Each service registers itself to (DiscoveryService) to mark their availability in init stage.

(GatewayService) redirects requests

(QuestionService) and (AnswerService) are responding any related queries. And also implement each other's clients to be able to communicate with each other (e.g. get answers for specific question). This is done by using Spring Cloud Open Feign which provides out of the box REST client. So if necessary these services can aggregate results from each other using REST.

### Samples

Using Postman: You may import each request/response samples to postman using `samples/survey-app.postman_collection.json`

Using Swagger UI: Simple enter http://localhost:4060/swagger-ui.html in your browser to see the details about each endpoint.

### How to run the app

git checkout

Import project to your idea - available run configs are in `.run/` folder. I used IDEA while developing so run configs should probably be auto-detected.

Run the services in the order mentioned in Structure section.
