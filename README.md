# NFT Marketplace

## Technology Stack & Tools

- SpringBoot
## Requirements For Initial Setup
- Install java 1.8

## Setting Up
### 1. Clone/Download the Repository 

### 2. Compile & Run application
```
$ cd demo
$ open command window cmd.exe
$ mvn clean install 
$ mvn spring:run 
```


### 3. Test api 

- open postman
- POST: http://localhost:8080/generate  

   request body:
  {
  "carrierName":"FreightmateCourierCo",
  "accountNumber":"123ABC",
  "digits":10,
  "lastUsedIndex":19604,
  "rangeStart":19000,
  "rangeEnd":20000
}
   
   


### 4. Run Tests
```
$ cd demo
$ open command window cmd.exe
$ mvn clean install 
```


### 5 Output

![Alt text](/images/Capture.png?raw=true "Output Postman")