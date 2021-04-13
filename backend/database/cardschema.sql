BEGIN TRANSACTION;

DROP TABLE IF EXISTS deck_cards;
DROP TABLE IF EXISTS card_keyword;
DROP TABLE IF EXISTS deck;
DROP TABLE IF EXISTS keyword;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS subject;

CREATE TABLE subject (
	subject_id serial PRIMARY KEY,
	subject_name varchar (50) 
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
	deck_name varchar (50) NOT NULL,
	description varchar (500) ,
	creator_id integer REFERENCES users (user_id)
);

CREATE TABLE deck_cards (
	deck_id integer REFERENCES deck (deck_id),
	card_id integer REFERENCES cards (card_id),

	CONSTRAINT pk_deck_id_card_id PRIMARY KEY (deck_id, card_id)
);


COMMIT TRANSACTION;
