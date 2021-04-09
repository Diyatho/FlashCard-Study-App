BEGIN TRANSACTION;

INSERT INTO subject (subject_name) VALUES ('Test');

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
('What color is the best color?', 'java green', (SELECT subject_id FROM subject WHERE subject_name = 'Color'), (SELECT user_id FROM users WHERE username = 'LindsayL'));

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

<<<<<<< HEAD
BEGIN TRANSACTION;


ROLLBACK
=======
SELECT * FROM cards WHERE answer = 'java green';

SELECT * FROM subject;

ROLLBACK;
>>>>>>> 52c6441cf28657b783a8469fd8b5e3bd6e6d8949
