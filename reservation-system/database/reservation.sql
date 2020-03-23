DROP TABLE IF EXISTS reservation;

CREATE TABLE reservation
(
        reservation_id SERIAL NOT NULL,
        name VARCHAR(256) NOT NULL,
        rate_id INTEGER NOT NULL,
        date_start DATE NOT NULL,
        date_end DATE NOT NULL
);


DROP TABLE IF EXISTS rate;

CREATE TABLE rate
(
        rate_id SERIAL,
        name VARCHAR(256) NOT NULL,
        description VARCHAR(256) NOT NULL,
        rate NUMERIC(4,2) NOT NULL
        
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