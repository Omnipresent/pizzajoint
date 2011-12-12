RESTful Pizzajoint
==================

This is my take on [students] (https://github.com/smanek/students) by smanek. Its a RESTful Java Web Service for taking pizza orders for a pizzajoint.

Details
-------

The following libraries are used

* Guice - Simplified Server
* JAX-RS - Java API for RESTful Web Services
* Jackson - JSON Processor for Java
* Guava - Type Inference, among other things

Let's eat some pizza
--------------------
Run the service

    % mvn tomcat:run

View the current orders

    % curl http://localhost:8080/pizzajoint/rest/orders
    []

Order a pizza for bob

    % curl -d "ordername=bob&readydate=12/10/2011&crust=thin&carryout=true&toppings=chicken,mushroom" http://localhost:8080/pizzajoint/rest/orders
    1

Order a pizza for joe

    % curl -d "ordername=joe&readydate=12/12/2011&crust=regular&toppings=pepperoni,chicken" http://localhost:8080/pizzajoint/rest/orders
    2

View the current orders

    % curl http://localhost:8080/pizzajoint/rest/orders
    [2,1]

View the order for bob

    % curl http://localhost:8080/pizzajoint/rest/orders/1
    {"toppings":["chicken","mushroom"],"id":1,"orderName":"bob","carryout":true,"dateOfOrder":"12-10-2011","crustType":"thin"}

View the order for joe

    % curl http://localhost:8080/pizzajoint/rest/orders/1
    {"toppings":["pepperoni","chicken"],"id":2,"orderName":"joe","carryout":false,"dateOfOrder":"12-12-2011","crustType":"regular"}
