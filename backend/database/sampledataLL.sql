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

SELECT question, answer, subject.subject_name 
FROM cards
JOIN subject USING (subject_id) WHERE creator_id = 3;

COMMIT TRANSACTION;

BEGIN TRANSACTION;