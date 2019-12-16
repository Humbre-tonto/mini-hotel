Insert into hotel.CONFIGURATION (KEY,VALUE,DESCRIPTION) values ('app.security.max-inactive-interval','3600','In seconds');
Insert into hotel.CONFIGURATION (KEY,VALUE,DESCRIPTION) values ('spring.jpa.show-sql','true',null);
Insert into hotel.CONFIGURATION (KEY,VALUE,DESCRIPTION) values ('server.port','8081',null);
Insert into hotel.CONFIGURATION (KEY,VALUE,DESCRIPTION) values ('logging.level.com.hotel.minihotel','debug','Logging level');
Insert into hotel.CONFIGURATION (KEY,VALUE,DESCRIPTION) values ('logging.level.org.springframework.security','debug','Logging level');



INSERT INTO "HOTEL"."APP_ROLE" (ID, CODE, ENGLISH_NAME) VALUES ('1', 'CUSTOMER', 'Customer')
INSERT INTO "HOTEL"."APP_ROLE" (ID, CODE, ENGLISH_NAME) VALUES ('2', 'EMPLOYEE', 'Employee')
INSERT INTO "HOTEL"."APP_ROLE" (ID, CODE, ENGLISH_NAME) VALUES ('3', 'MANAGER', 'manager')
