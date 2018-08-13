# primitive-bank
This API service is to provide functionalities like check balance, withdraw and deposit into a bank account.

## Start procedure
### IDE
just run `main` method in `com.assignment.PrimitiveBankApplication` class

JAR
------------------
Build the JAR using maven
```
mvn clean install
```
Run the application using
```
java -jar primitive-bank-1.0.0.jar
```

## Current APIs

Once the server is started it launches the application on port 8080 (http://localhost:8080/swagger-ui.html) and serves SwaggerUI where we can inspect and try existing endpoints.

### To find Customer based on id:
#### /v1/xyzbank/customer/{id}
Usage
```
curl -X GET "http://localhost:8080/v1/xyzbank/customer/1" -H "accept: */*"
```

### To find Accounts linked to Customer:
#### /v1/xyzbank/customer/{id}/account
Usage
```
curl -X GET "http://localhost:8080/v1/xyzbank/customer/1/account" -H "accept: */*"
```

### To check balance for an account:
#### /v1/xyzbank/customer/{id}/account/{accId}/balance
Usage
```
curl -X GET "http://localhost:8080/v1/xyzbank/customer/1/account/1/balance" -H "accept: */*"
```

### To deposit money into an account:
#### /v1/xyzbank/customer/{id}/account/{accId}/deposit
Usage
```
curl -X POST "http://localhost:8080/v1/xyzbank/customer/1/account/1/deposit" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"currency\": \"EUR\", \"value\": 120}"
```


### To withdraw money from an account
#### /v1/xyzbank/customer/{id}/account/{accId}/withdraw
```
curl -X POST "http://localhost:8080/v1/xyzbank/customer/1/account/1/withdraw" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"currency\": \"EUR\", \"value\": 50}"
```
