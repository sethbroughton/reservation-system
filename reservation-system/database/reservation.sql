DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation
(
        reservation_id SERIAL NOT NULL,
        venue_id INTEGER NOT NULL,
        client_id INTEGER NOT NULL,
        rate_id INTEGER NOT NULL,
        date_start DATE NOT NULL,
        date_end DATE NOT NULL,
        date_created DATE NOT NULL
     --   weekend boolean NOT NULL,
      --  weekday boolean NOT NULL,
       -- holiday boolean NOT NULL,
  
);

DROP TABLE IF EXISTS client;

CREATE TABLE client
(
        client_id SERIAL NOT NULL,
        phone_number VARCHAR(64) not null,
        email_address VARCHAR(64) not null
        
);

DROP TABLE IF EXISTS reservation_service;

CREATE TABLE reservation_service
(
        reservation_id INTEGER NOT NULL,
        service_id INTEGER NOT NULL

);

DROP TABLE IF EXISTS venue;

CREATE TABLE venue
(
        venue_id SERIAL NOT NULL, 
        name VARCHAR(256) NOT NULL,
        description VARCHAR(256) NOT NULL,
        capacity INTEGER NOT NULL,
        image VARCHAR(256) NOT NULL
);

INSERT INTO venue (name, description, capacity, image)
VALUES ('Elizabeth Sugden Broughton Community Building', 'Multi-USE Community Building', 285, 'ESB.jpg'); 


DROP TABLE IF EXISTS rate;

CREATE TABLE rate
(
        rate_id SERIAL NOT NULL,
        venue_id INTEGER NOT NULL, 
        name VARCHAR(256) NOT NULL,
        description VARCHAR(256) NOT NULL,
        rate_dollar Integer NOT NULL,
        includes_cleaning_fee boolean NOT NULL,
        starting_month VARCHAR(256) NOT NULL,
        ending_month VARCHAR(256) NOT NULL,
        weekend boolean NOT NULL,
        weekday boolean NOT NULL,
        holiday boolean NOT NULL
);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Weekday',1,'Monday-Friday before 4:30', 350, false, 'January', 'December', false, true, false);

INSERT INTO rate (name, venue_id,description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Weekday-Evening',1,'Monday-Friday after 4:30', 500, false, 'January', 'December', false, true, false); 

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Saturday',1,'Saturday Only', 900, false, 'January', 'December', true, false, false);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Sunday - All Day',1,'Sunday Only', 500, false, 'January', 'December', true, false, false);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Sunday - Evening',1,'Sunday 12pm to 6pm', 500, false, 'January','December', true, false, false);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Full Weekend - In Season',1,'Friday 5pm to Sunday 10am', 2000, true, 'April','October', true, false, false);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Full Weekend - Off Season',1,'Friday 5pm to Sunday 10am', 1750, true, 'November','March', true, false, false);

INSERT INTO rate (name, venue_id, description, rate_dollar, includes_cleaning_fee, starting_month, ending_month, weekend, weekday, holiday)
VALUES ('Special Holiday',1, 'Holiday Rate', 1250, true, 'January','December', false, false, true);


DROP TABLE IF EXISTS service;

CREATE TABLE service
(
        service_id SERIAL NOT NULL, 
        name VARCHAR(256) NOT NULL,
        description VARCHAR(256) NOT NULL, 
        rate_dollar Integer NOT NULL
);

INSERT INTO service (name, description, rate_dollar)
VALUES ('Audio Rental', 'Audio Rental', 100 );

INSERT INTO service (name, description, rate_dollar)
VALUES ('Audio/Visual Rental', 'Audio/Visual Rental', 150 );

INSERT INTO service (name, description, rate_dollar)
VALUES ('Kitchen use cold/prep kitchen', 'Kitchen use of refrigerator, 3 bowl sink, microwaves', 100 );

INSERT INTO service (name, description, rate_dollar)
VALUES ('Catering/Beverage Closet', 'Includes bar sink, keg holder, ice maker, cabinets and counter - available prior to event', 100 );

INSERT INTO service (name, description, rate_dollar)
VALUES ('Outside Keg Holder', 'Outside Keg Holder', 20 );

INSERT INTO service (name, description, rate_dollar)
VALUES ('Set-up of Tables and Chairs', 'The Broughton Foundation sets up and tears down all tables and chairs ', 150 );

        SELECT * FROM rate;
        SELECT * from service;
        SELECT * FROM reservation;