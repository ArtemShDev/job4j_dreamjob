CREATE TABLE if not exists post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      created data
);

CREATE TABLE if not exists candidates (
                            id SERIAL PRIMARY KEY,
                            name varchar(200),
                            created data,
                            city_id SERIAL REFERENCES cities(id)
);

CREATE TABLE if not exists cities (
                            id SERIAL PRIMARY KEY,
                            name varchar(100)
);

-- INSERT into cities(name) values('Moscow');
-- INSERT into cities(name) values('Spb');
-- INSERT into cities(name) values('Rostov');
-- INSERT into cities(name) values('Torzhok');