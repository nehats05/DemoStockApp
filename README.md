Objective of the project is to build an application in SpringBoot that will allow multiple users to perform the following operations concurrently.
1.Upload a bulk data set
2.Query for data by stock ticker (e.g. input: AA, would return 12 elements if the only data uploaded were the single data set above)
3.Add a new record
Sample data is a collection of records from the [Dow Jones Index from 2011](http://archive.ics.uci.edu/ml/datasets/Dow+Jones+Index#). 

Inorder to complete the above mentioned tasks, following considerations are made.
1.Upload Bulk Data Set
Considering the Dow Jones Data file having 16 attributes with comma separated values,for uploading the file used Multipart file upload with the CSV Parser to read the data from file, validate the fields, map to the model class and save to the Mysql database.  
2.Query for data by stock name
Inorder to fetch the result records for the given stock name, fetch the composite keys and get the records for the latest quarter.
3.Add a new record
Validate the input record against the composite keys and store in the database.

Included the Test Class for fetching and inserting record using the MockMvc with data field validation and Logger from slf4j.
Included Swagger UI to test the REST API : localhost:8080/swagger-ui/index.html

Dependencies and Technologies used:
1.SpringBoot 2.7.4
2.spring-boot-starter-web : Starter for building web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.
3.spring-boot-starter-test :Starter for testing Spring Boot applications with libraries including JUnit with MockMVC.
3.mysql-connector-java : Connect to MYsql DB with version 8.0.20
4.spring-boot-starter-data-jpa : Starter for access and persist data between class and DB.
5.commons-csv: version 1.8 to aceess the CSSV Parser from apache commons.
6.springfox-boot-starter: Version 3.0.0 for Swagger UI implementation.
7.Java SDK version 11 

Scope for Future Enhancements:
1.Uploading the data with the different file extensions.
2.Validity check for the data attributes.
3.Sequence injection check.
4.Filter for the composite keys or other attributes.
5.Analytics for stock performance for the givven quarter.
6.Development of UI for the operations.
