BEGIN TRANSACTION;

DROP TABLE IF EXISTS deck_cards;
DROP TABLE IF EXISTS card_keyword;
DROP TABLE IF EXISTS deck;
DROP TABLE IF EXISTS keyword;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS subject;

CREATE TABLE subject (
	subject_id serial PRIMARY KEY,
	subject_name varchar (50) NOT NULL
);

CREATE TABLE cards (
	card_id serial PRIMARY KEY,
	question varchar (1000) NOT NULL,
	answer varchar (1000) NOT NULL,
	subject_id integer REFERENCES subject (subject_id),
	creator_id integer REFERENCES users (user_id)
);

CREATE TABLE keyword (
	keyword_id serial PRIMARY KEY,
	keyword varchar (50)  NOT NULL
);

CREATE TABLE card_keyword (
	card_id integer REFERENCES cards (card_id),
	keyword_id integer REFERENCES keyword (keyword_id),

	CONSTRAINT pk_card_id_keyword_id PRIMARY KEY (card_id, keyword_id)
);

CREATE TABLE deck (
	deck_id serial PRIMARY KEY,
	deck_name varchar (50) NOT NULL
);

CREATE TABLE deck_cards (
	deck_id integer REFERENCES deck (deck_id),
	user_id integer REFERENCES users (user_id),
	card_id integer REFERENCES cards (card_id),
	answeredCorrect boolean DEFAULT false ,

	CONSTRAINT pk_deck_id_user_id_card_id PRIMARY KEY (deck_id, user_id, card_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO subject (subject_name) VALUES ('Test');

INSERT INTO cards (question, answer, subject_id, creator_id) 
VALUES
('What color is the sky?', 'blue', 1, 1),
('What is the name of this app?', 'TEHoot', 1, 1);



ROLLBACK;

COMMIT TRANSACTION;
