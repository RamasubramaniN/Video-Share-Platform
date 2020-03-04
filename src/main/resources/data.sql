DROP TABLE IF EXISTS Player;

CREATE TABLE Player (
	id NUMBER(5,0),
	name VARCHAR2(25),
	team VARCHAR2(25),
	age NUMBER(3,0),
	runs NUMBER(5,0),
	rank NUMBER(3,0)
);

 
INSERT INTO Player (id, name, team, age, runs, rank) VALUES
  (1, 'Tendulkar', 'India', 41, 15000, 1);
INSERT INTO Player (id, name, team, age, runs, rank) VALUES
  (2, 'Viv Richards', 'Westindies', 51, 6000, 2);
INSERT INTO Player (id, name, team, age, runs, rank) VALUES
  (3, 'MS Dhoni', 'India', 37, 9000, 5);
INSERT INTO Player (id, name, team, age, runs, rank) VALUES
  (4, 'A B De Villiars', 'South Africa', 34, 7000, 3);
INSERT INTO Player (id, name, team, age, runs, rank) VALUES
  (5, 'Sehwag', 'India', 39, 9000, 4);
