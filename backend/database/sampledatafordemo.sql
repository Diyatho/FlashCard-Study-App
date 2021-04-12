/*sample data for demo*/
/*this script hardcodes data for user_id 1, with the purpose to demo look and functionality of application*
/*3 Decks will be added with 10 cards each, subjects, keywords for those cards will also be populated*/

BEGIN TRANSACTION;

INSERT INTO deck
(deck_name, description, creator_id)
VALUES
('Tech Terms', 'To practice Tech Terms.', 1),
('Bad Jokes', 'To practice telling bad jokes.', 1),
('Spanish Vocab', 'To practice my Spanish vocab.', 1);

INSERT INTO subject
(subject_name)
VALUES
('Technology'),
('Jokes'),
('Spanish');

INSERT INTO cards
(question, answer, subject_id, creator_id)
VALUES
/*Tech Terms*/
('What does OOP stand for?', 'Object Oriented Programming', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define Object Oriented Programming', 'A type of programming that uses encapsulation, inheritance, abstraction, and polymorphism to prevent redundancy in code.', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define Encapsulation', 'Encapsulation is the packaging of attributes and methods together in Objects', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define Inheritance', 'Inheritance allows classes to derive from other classes. A sub-class can take in certain attributes and methods from its parent and add on to it to specify.', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define Abstraction', 'Abstraction educes impact of change, means interface and use is simpler, data and complexity is hidden away.', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define Polymorphism', 'Polymorphism enables the same method to be used differently depending on the hierarchy of inheritance. Ex - a dog can be fed as an animal and the computer will know to feed it like a dog.
', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('What does API stand for?', 'Application Programming Interface', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define API.', 'An API is a set of commands, functions, protocols, and objects that programmers can use to create software or interact with an external system.', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('What does MVC stand for?', 'Model View Controller', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
('Define REST API', 'REST API is a simplified and standardized communication from client to server, scaleable and stateless, high performance,', (SELECT subject_id FROM subject WHERE subject_name = 'Technology'), 1),
/*Bad Jokes*/
('What rock group has four men that don''t sing?','Mount Rushmore', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('Why do melons have weddings?', 'Because they cantaloupe!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('What''s brown and sticky?', 'A stick!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('Why was the coach yelling at a vending machine?', 'He wanted his quarter back.', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('What do sprinters eat before a race?', 'Nothing. They''re fast!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('Why couldn''t the bicycle stand up by itself?', 'It was two tired!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('Why did the scarecrow win an award?', 'Because he was outstanding in his field!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('What do Santa''s elves listen to as they work?', 'Wrap music', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('After an unsuccessful harvest, why did the farmer decide to try a career in music?', 'Because he had a ton of sick beets.', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
('What do you call a fake noodle?', 'An Impasta!', (SELECT subject_id FROM subject WHERE subject_name = 'Jokes'), 1),
/*Spanish Vocab Cards*/
('cat', 'el gato', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('tree','el àrbol', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('cheese', 'el queso', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('water', 'el agua', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('telephone', 'el teléfono', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('computer', 'el ordenador', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('job', 'el trabajo', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('book', 'el libro', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('apple', 'la manzana', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1),
('house', 'la casa', (SELECT subject_id FROM subject WHERE subject_name = 'Spanish'), 1);


INSERT INTO deck_cards
(deck_id, card_id)
VALUES
/*Tech Terms*/
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
/*Bad Jokes*/
(2, 11),
(2, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16),
(2, 17),
(2, 18),
(2, 19),
(2, 20),
/*Spanish Vocab*/
(3, 21),
(3, 22),
(3, 23),
(3, 24),
(3, 25),
(3, 26),
(3, 27),
(3, 28),
(3, 29),
(3, 30);

INSERT INTO keyword
(keyword)
VALUES
('OOP'),
('API'),
('programming'),
('joke'),
('Christmas'),
('food'),
('Spanish'),
('animal'),
('noun');

INSERT INTO card_keyword
(card_id, keyword_id)
VALUES
(1, 1),
(1, 3),
(2, 1),
(2, 3),
(3, 1),
(3, 3),
(4, 1),
(4, 3),
(5, 1),
(5, 3),
(6, 1),
(6, 3),
(7, 2),
(7, 3),
(8, 2),
(8, 3),
(9, 3),
(10, 2),
(10, 3),
(11, 4),
(12, 4),
(12, 6),
(13, 4),
(14, 4),
(15, 4),
(16, 4),
(17, 4),
(18, 4),
(18, 5),
(19, 4),
(19, 6),
(20, 4),
(20, 6),
(21, 7),
(21, 8),
(21, 9),
(22, 7),
(22, 9),
(23, 7),
(23, 6),
(24, 7),
(24, 9),
(25, 7),
(25, 9),
(26, 7),
(26, 9),
(27, 7),
(27, 9),
(28, 7),
(28, 9),
(29, 7),
(29, 6),
(29, 9),
(30, 7),
(30, 9);



COMMIT TRANSACTION;



