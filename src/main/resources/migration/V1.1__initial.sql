CREATE TABLE consumption_type (
  value VARCHAR(255) PRIMARY KEY
);

INSERT INTO consumption_type (value) VALUES
  ('TAXI'),
  ('FOOD'),
  ('ALCOHOL'),
  ('SPORT'),
  ('CLOTHES');

CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE money_consumption_record (
  id               BIGINT PRIMARY KEY DEFAULT nextval('hibernate_sequence'),
  description      VARCHAR(255),
  consumption_type_value VARCHAR(255) NOT NULL,
  sum              BIGINT       NOT NULL,
  creation_date    DATE,
  FOREIGN KEY (consumption_type_value) REFERENCES consumption_type
);
