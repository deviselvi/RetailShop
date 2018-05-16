# Retail
This Application created by using environment.
* OPEN IDE
* Mysql data base or Oracle (both Oracle and MySQL configuration is avaliable in retailsshop\src\main\resources\application.properties. This can be commented/uncommented based on requirements.)
* Spring Boot with JPA framework



For this application database name is 'Retail'. In this database i have created 4 tables. 
'USERDTLS' having fields:
USER_ID,USER_NAME,USER_TYPE,CREATED_DATE,UPDATED_DATE,PRODUCT_ID,USER_TYPE

'PRODUCTDTLS' having fields:
PRODUCT_ID,PRODUCT_NAME,PRODUCT_TYPE,PRODUCT_COST

'DISCOUNT' having fields:
DISCOUNT_CODE,DISCOUNT_PERCENTAGE,ABOVE_COST,USER_TYPE_CODE,USER_TYPE

'USER_TYPE' having fields:
USER_TYPE_CODE,USER_TYPE_NAME

I have written POST API to insert data in both table for testing.
http://localhost:8084/retail/saveuser
http://localhost:8084/retail/saveproduct
http://localhost:8084/retail/calculateBill
http://localhost:8084/retail/getdiscount


Notes: 

1. Configured and Enabled Logging in debug level.
2. Implemented Spring boot service to achieve the goal (adding discounts to products)
3. Added Custom exception in case of exception
4. Followed Object oriented concepts
5. Added Testcases
6. UML diagram is available @ https://go.gliffy.com/go/publish/12655357

