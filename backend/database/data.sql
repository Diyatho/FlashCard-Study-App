INSERT INTO SUBJECT
(subject_name)
VALUES
('Biology');

INSERT INTO CARDS
(question, answer, subject_id, creator_id)
VALUES
('How many bones are there in the human body', '206', 2, 3 )

SELECT deck_id, deck_name, description, creator_id FROM deck
WHERE creator_id = (SELECT user_id FROM users WHERE username = 'diya')