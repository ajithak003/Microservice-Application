# Microservice-Application
Tourist Management Microservice Application

## Discovery Service 
* Using to register microservices.

## Authentication Service
* Using Spring Security JWT(Json Web Token) to authenticate user credentials.
* Provide login feature to generate JWT Token. 

## API Gateway
* Routing variours service request and authenticate / validate JWT token.

## User Service
* Provide User Register, Details update and get all user details features.

## Package Booking Service
* Provide to create new tourist booking place and fetch all place features.
* Provide to book a tourist place for registered user.
* Using Open Feign client service to service communication to fetch payment details against the booking id from payment service.

## Payment Service
* Provide to payment a tourist place booking.
