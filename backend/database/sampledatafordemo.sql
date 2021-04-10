/*sample data for demo*/
/*this script hardcodes data for user_id 1, with the purpose to demo look and functionality of application*
/*3 Decks will be added with 10 cards each, subjects, keywords for those cards will also be populated*/

BEGIN TRANSACTION;

INSERT INTO deck
(deck_name)
VALUES
('Tech Terms'),
('Bad Jokes'),
('Spanish Vocab');

INSERT INTO subject
(subject_name)
VALUES
(),
(),
('nouns');

INSERT INTO cards
(question, answer, subject_id, creator_id)
VALUES
/*Tech Terms*/
('', '', , ),
(),
(),
(),
(),
(),
(),
/*Bad Jokes*/
("What rock group has four men that don't sing?",'Mount Rushmore', 2, 3),
('Why do melons have weddings?', 'Because they cantaloupe!', 2, 3),
("What's brown and sticky?", 'A stick!', 2, 3),
('Why was the coach yelling at a vending machine?', 'He wanted his quarter back.', 2, 3),
('What do sprinters eat before a race?', "Nothing. They're fast!", 2, 3),
("Why couldn't the bicycle stand up by itself?", 'It was two tired!', 2, 3),
('', '', 2, 3),
('', '', 2, 3),
('', '', 2, 3),
('', '', 2, 3),
/*Spanish Vocab Cards*/
('cat', 'el gato', 3, 1),
('tree','el àrbol', 3, 1),
('cheese', 'el queso', 3, 1),
('water', 'el agua', 3, 1),
('telephone', 'el teléfono', 3, 1),
('computer', 'el ordenador', 3, 1),
('job', 'el trabajo', 3, 1),
('book', 'el libro', 3, 1),
('apple', 'la manzana', 3, 1),
('house', 'la casa', 3, 1);


INSERT INTO deck_cards
(deck_id, card_id)
VALUES
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
();

INSERT INTO keywords
(keyword)
VALUES
(),
(),
(),
(),
(),
(),
(),
();

INSERT INTO card_keyword
(card_id, keyword_id)
VALUES
(),
(),
(),
();




