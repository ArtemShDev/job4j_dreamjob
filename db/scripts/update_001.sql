CREATE TABLE if not exists post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      created date
);

CREATE TABLE if not exists cities (
                                      id SERIAL PRIMARY KEY,
                                      name varchar(100)
    );

CREATE TABLE if not exists candidates (
                            id SERIAL PRIMARY KEY,
                            name varchar(200),
                            created date,
                            city_id SERIAL REFERENCES cities(id)
);

INSERT into cities(name) values('Moscow');
INSERT into cities(name) values('Spb');
INSERT into cities(name) values('Rostov');
INSERT into cities(name) values('Torzhok');