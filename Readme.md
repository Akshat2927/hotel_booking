## Prerequisites to run the project ##

-> Java 21
-> PostgreSQL installed & running
-> Maven
-> Postman (for API testing)

## Setup Instruction ##

1. ** Clone the repository **
   git clone 
   cd hotel-booking-system


2. ** Create PostgreSQL Database **
   Open pgAdmin-> server-> database-> Right click on database-> Click Create 
   -> Database-> Enter Database name-> Leave Owner as default-> Click Save

3. ** Configure application.properties **4
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_postgres_password
   spring.datasource.driver-class-name=org.postgresql.Driver

    --- JPA Configuration ---
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

4. ** Run the Spring Boot Application **
   Server will start at: http://localhost:8080

## API Endpoints ##

1. Add a Hotel
   Method-> POST
   Endpoint-> http://localhost:8080/hotels

   Request Body:-
   {
   "name": "The Taj Palace",
   "city": "Delhi",
   "totalRooms": 100,
   "pricePerNight": 5500
   }

   Response:-
   {
   "id": "1",
   "name": "The Taj Palace",
   "city": "Delhi",
   "totalRooms": 100,
   "pricePerNight": 5500
   }

2. Get All Hotels
   Method-> GET
   Endpoint-> http://localhost:8080/hotels

   Response:-
   [
   {
   "id": "1",
   "name": "The Taj Palace",
   "city": "Delhi",
   "totalRooms": 100,
   "pricePerNight": 5500
   }
   ]

3. Search Hotels by City
   Method-> GET
   Endpoint-> http://localhost:8080/hotels/search?city=city_name

   Example:-
   Endpoint-> http://localhost:8080/hotels/search?city=Delhi

   Response:-
   {
   "id": "1",
   "name": "The Taj Palace",
   "city": "Delhi",
   "totalRooms": 100,
   "pricePerNight": 5500
   }

4. Book a Hotel
   Method-> POST
   Endpoint-> http://localhost:8080/bookings

   Request Body:
   {
   "hotelId": "1",
   "customerName": "XYZ",
   "checkInDate": "2025-08-10",
   "checkOutDate": "2025-08-15"
   }

   Response:
   {
   "message": "Hotel Booked Successfully",
   "hotelId": "1",
   "hotelName": "The Taj Palace",
   "customerName": "XYZ",
   "checkInDate": "2025-08-10",
   "checkOutDate": "2025-08-15"
   }

## IMPORTANT ##
Format of  Date--> yyyy-MM-dd




