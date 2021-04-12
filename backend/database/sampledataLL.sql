BEGIN TRANSACTION;

NSERT INTO subject (subject_name) VALUES ('Test');

INSERT INTO cards (question, answer, subject_id, creator_id) 
VALUES
('What color is the sky?', 'blue', 1, 1),
('What is the name of this app?', 'TEHoot', 1, 1);


INSERT INTO cards (question, answer, subject_id, creator_id)
VALUES
('What color is the grass?', 'green', 1, 3),
('What color is sand?', 'tan', 1, 3),
('What color is a banana?', 'green or yellow', 1, 3);



COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO keyword
(keyword)
VALUES
('color'),
('grass'),
('tan'),
('banana');

INSERT INTO card_keyword
(card_id, keyword_id)
VALUES
(3, 1),
(3, 2),
(4, 1),
(4, 3),
(5, 1),
(5, 4);

SELECT question, answer, subject.subject_name 
FROM cards
JOIN subject USING (subject_id) 
JOIN users USING (
WHERE users.username = 'LindsayL';

SELECT question, answer, subject.subject_name 
FROM cards
JOIN subject USING (subject_id) 
JOIN users ON creator_id = user_id
WHERE users.username= 'LindsayL' AND card_id = 5;

SELECT question, answer, subject.subject_name
FROM cards 
JOIN subject USING (subject_id)
JOIN users ON creator_id = user_id
WHERE users.username = 'LindsayL' AND subject.subject_name = 'Test'; 


SELECT card_id, question, answer, subject.subject_name, 
FROM cards
JOIN subject USING (subject_id)
JOIN card_keyword USING (card_id)
JOIN keyword USING (keyword_id)
JOIN users ON creator_id = user_id
WHERE users.username = 'LindsayL' AND keyword.keyword ILIKE 'java';




/*addCard includes addSubject, addKeywords*/
BEGIN TRANSACTION;

/*addSubject*/
INSERT INTO subject
(subject_name)
VALUES
('Color');

/*add card*/
INSERT INTO cards
(question, answer, subject_id, creator_id)
VALUES
('What color is the best color?', 'java green', 
(SELECT subject_id FROM subject WHERE subject_name = 'Color'), 
(SELECT user_id FROM users WHERE username = 'LindsayL'));

/*addKeyword */
INSERT INTO keyword
(keyword)
VALUES
('java');

INSERT INTO card_keyword
(card_id, keyword_id)
VALUES
((SELECT card_id FROM cards WHERE answer = 'java green'),(SELECT keyword_id FROM keyword WHERE keyword = 'java'));

COMMIT TRANSACTION;

SELECT * FROM cards WHERE answer = 'java green';

SELECT * FROM subject;

SELECT subject_id, subject_name FROM subject WHERE subject_name = 'Test';

INSERT INTO cards (question, answer, subject_id, creator_id)
VALUES ('What is my name', 'Lindsay', (SELECT subject_id FROM subject WHERE subject_name = 'Test'), (SELECT user_id FROM users WHERE username = 'LindsayL'));

BEGIN TRANSACTION;

SELECT question, answer, subject.subject_name, cards.creator_id
FROM cards
JOIN subject USING (subject_id)
JOIN deck_cards USING (card_id)
JOIN deck USING (deck_id)
WHERE deck.deck_id = (SELECT deck.deck_id FROM deck WHERE deck_name = 'Banjo');

/*GET CARDS BY DECK ID*/
SELECT card_id, question, answer, subject.subject_name, (SELECT username FROM users WHERE user_id = cards.creator_id) AS card_creator, deck.deck_name
FROM cards
JOIN subject USING (subject_id)
JOIN deck_cards USING (card_id)
JOIN deck USING (deck_id)
WHERE deck_id = 1;

/*GET CARD BY ID*/
SELECT card_id, question, answer, subject.subject_name, (SELECT username FROM users WHERE user_id = cards.creator_id) AS card_creator, deck.deck_name
FROM cards 
JOIN subject USING (subject_id)
JOIN deck_cards USING (card_id)
JOIN deck USING (deck_id)
WHERE card_id = 1;

/*get Deck - w/ update from creator id to "deck_creator"*/
SELECT deck_id, deck_name, description, (SELECT username FROM users WHERE user_id = deck.creator_id) AS deck_creator
FROM deck
WHERE deck_id = ?;

SELECT deck_id, deck_name, description, creator_id
FROM deck
WHERE deck_id = 1;

/*UPDATE CARD - question, answer, subject*/
UPDATE cards
SET
question = ?,
answer = ?,
subject_id = ?
WHERE card_id = ?;

/*UPDATE subject*/
UPDATE subject
SET 
subject_name = ?
WHERE subject_id = ?;


/*DELETE CARD*/

/*UPDATE DECK - name and description*/
BEGIN TRANSACTION;
UPDATE deck
SET 
deck_name = 'US Presidents', 
description = 'Study the presidents of the US'
WHERE deck_id = 8;

/*CHECK if Deck already exists*/
SELECT deck_name 
FROM deck
WHERE deck_name = ? AND creator_id = (SELECT user_id FROM users WHERE username = ?);

BEGIN TRANSACTION;

INSERT INTO deck (deck_name, creator_id) VALUES ('Spanish Verbs', (SELECT user_id FROM users WHERE username = 'LindsayL'));
SELECT * FROM deck WHERE deck_name = 'Spanish Verbs';

/*getCardCreatorByCardId*/
SELECT deck_id
FROM cards 
JOIN deck_cards USING (card_id)
JOIN deck USING (deck_id)
WHERE deck_name = 'Dogs' AND card_id = 38;

INSERT INTO deck (deck_name) VALUES (?);

BEGIN TRANSACTION;
DELETE FROM deck 
WHERE deck_id = 10;
SELECT * FROM deck;
ROLLBACK;

COMMIT TRANSACTION;
