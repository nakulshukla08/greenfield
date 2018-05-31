This project has three endpoints for -
1. Creating Account.
2. Getting account details.
3. Transfering amount from one account to another.

API documentation can be seen at - http://localhost:18080/swagger-ui.html

Enhancements -

1. In order to make the application production ready, application metrics should be added which will help in monitoring 
   real time application performance. This can be done by enabling spring actuator and exposing OOTB metrics through dedicated actuator 
   metrics endpoint.
2. Dedicated endpoints should be created in application for kubernetes liveness and readiness probe. Spring actuator can be used 
   to implement the health endpoint to monitor application health. Any default health indicators or custom health indicator can be used for 
   this purpose.
