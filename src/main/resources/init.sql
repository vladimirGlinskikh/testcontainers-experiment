DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         SERIAl PRIMARY KEY,
    first_name VARCHAR(50),
    last_name  VARCHAR(50)
);

INSERT INTO users (first_name, last_name)
VALUES ('Vladimir', 'Glinskikh'),
       ('Leonid', 'Romanov'),
       ('Alexander', 'Bulatov'),
       ('Yurkevich', 'Pavel'),
       ('Ostapenko', 'Anastasia');