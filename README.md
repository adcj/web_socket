
## Overview:
The primary target for this code sample is to design and develop a Java Back-end server that will:
1. Register Redis message listener and consumer
2. Register WebSocket end points
3. Accept (REST API) incoming messages and cache them in Redis. Once done will broadcast them to all browser clients via WebSocket
4. (Redis) consumer will receive each new message and persist them in MongoDB
5. Expose (REST API) endpoint for retrieving all stored messages in MongoDB

For testing purposes, there is also a simple browser client/front-end that will display the new messages broadcasted from the back-end

## High Level Design:
![Image](hld.png)

## Technologies/Tools/Frameworks used:
- Java JEE / Spring Boot
- MongoDB
- Redis Server
- WebSocket
- AngularJS
- HTML/CSS
- Tomcat
- Docker

## Execution:

## Exposed endpoints:

## Pending work:
