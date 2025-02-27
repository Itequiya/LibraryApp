USE library;
INSERT INTO address (street, city, state, zip_code, country)
values ('Av. Andromeda 207', 'León', 'Guanajuato', '37322', 'México');

INSERT INTO library (name, address_id)
values ('Itéquiya', 1);

INSERT INTO role (name) VALUES ('Admin'), ('User');
SELECT * FROM role;

INSERT INTO user (name, lastname, mail, phone, role_id)
VALUES ('Zurisadaí', 'Becerra', 'sadai.bp98@gmail.com', '4772286180', 1);
INSERT INTO user (name, lastname, mail, phone, role_id) 
VALUES 
('Elias Jair',' Velázquez','bbcito@gmail.com', '4777501950', 2),
('Lizbeth Torres',' Soto','gorda@gmail.com', '4776583520', 2),
('Iván',' López','pitudo@gmail.com', '4774374109', 2),
('Leslie', ' Aguilera','tacos@gmail.com', '4779872154', 2),
('Eduardo', ' Quiñones', 'cochino@gmail.com', '4778705201', 2);

INSERT INTO category (name)
VALUES ('Literature'),
('Science Fiction'),
('Romance'),
('Philosophy'),
('Young Adult');

INSERT INTO book (title, author, pages, editorial, library_id)
VALUES 
('One Hundred Years of Solitude', 'Gabriel García Márquez', 417, 'Sudamericana', 1),
('Don Quixote', 'Miguel de Cervantes', 863, 'Francisco de Robles',1),
('Pride and Prejudice', 'Jane Austen', 432, 'T. Egerton',1),
('1984', 'George Orwell', 328, 'Secker & Warburg',1),
('The Little Prince', 'Antoine de Saint-Exupéry', 96, 'Reynal & Hitchcock',1),
('Crime and Punishment', 'Fyodor Dostoevsky', 671, 'The Russian Messenger',1),
('Fahrenheit 451', 'Ray Bradbury', 256, 'Ballantine Books',1),
('The Hunger Games', 'Suzanne Collins', 374, 'Scholastic',1),
('Sophie’s World', 'Jostein Gaarder', 518, 'Farrar, Straus and Giroux',1),
('The Republic', 'Plato', 416, 'Ancient Greece',1),
('Dune', 'Frank Herbert', 412, 'Chilton Books',1),
('Love in the Time of Cholera', 'Gabriel García Márquez', 348, 'Oveja Negra',1),
('The Fault in Our Stars', 'John Green', 313, 'Dutton Books',1),
('Les Misérables', 'Victor Hugo', 1463, 'A. Lacroix, Verboeckhoven & Cie',1),
('Foundation', 'Isaac Asimov', 255, 'Gnome Press',1),
('Hopscotch', 'Julio Cortázar', 576, 'Sudamericana',1),
('Romeo and Juliet', 'William Shakespeare', 219, 'First Folio',1),
('The Perks of Being a Wallflower', 'Stephen Chbosky', 213, 'MTV Books',1),
('Moby Dick', 'Herman Melville', 635, 'Harper & Brothers',1),
('The Alchemist', 'Paulo Coelho', 208, 'HarperOne',1);

INSERT INTO category_book (book_id, category_id)
VALUES 
(1, 1),  -- One Hundred Years of Solitude - Literature
(2, 1),  -- Don Quixote - Literature
(3, 3),  -- Pride and Prejudice - Romance
(4, 2),  -- 1984 - Science Fiction
(5, 5),  -- The Little Prince - Young Adult
(6, 1),  -- Crime and Punishment - Literature
(7, 2),  -- Fahrenheit 451 - Science Fiction
(8, 5),  -- The Hunger Games - Young Adult
(9, 4),  -- Sophie’s World - Philosophy
(10, 4), -- The Republic - Philosophy
(11, 2), -- Dune - Science Fiction
(12, 3), -- Love in the Time of Cholera - Romance
(13, 3), -- The Fault in Our Stars - Romance
(14, 1), -- Les Misérables - Literature
(15, 2), -- Foundation - Science Fiction
(16, 1), -- Hopscotch - Literature
(17, 3), -- Romeo and Juliet - Romance
(18, 5), -- The Perks of Being a Wallflower - Young Adult
(19, 1), -- Moby Dick - Literature
(20, 4); -- The Alchemist - Philosophy

INSERT INTO status_copy (name, description)
VALUES 
('Available', 'The book copy is available for loan'),
('On Loan', 'The book copy is currently borrowed'),
('Overdue', 'The Book copy has passed the return date'),
('Damaged', 'The book copy is damaged and cannot be borrowed'),
('Lost', 'The book copy is lost and cannot be returned');

INSERT INTO copy (book_id, status_copy_id)
VALUES 
(1, 1), (1, 1), -- Two copies for 'One Hundred Years of Solitude'
(20, 2), (20, 1),-- Three copies for 'The Alchemist'
(2, 1), (2, 1), -- Two copies for 'Don Quixote'
(4, 1), (4, 4), -- Two copies for '1984'
(5, 3), (5, 1), -- Two copies for 'The Little Prince'
(6, 1), (6, 4), -- Two copies for 'Crime and Punishment'
(7, 3), (7, 1), -- Two copies for 'Fahrenheit 451'
(8, 2), (8, 2), -- Two copies for 'The Hunger Games'
(9, 1), (9, 3), -- Two copies for 'Sophie’s World'
(10, 2), (10, 1), -- Two copies for 'The Republic'
(11, 1), (11, 2), -- Two copies for 'Dune'
(12, 2), (12, 1), -- Two copies for 'Love in the Time of Cholera'
(13, 2), (13, 5), -- Two copies for 'The Fault in Our Stars'
(14, 1), (14, 1), -- Two copies for 'Les Misérables'
(15, 2), (15, 1), -- Two copies for 'Foundation'
(16, 1), (16, 5), -- Two copies for 'Hopscotch'
(17, 1), (17, 3), -- Two copies for 'Romeo and Juliet'
(18, 4), (18, 2), -- Two copies for 'The Perks of Being a Wallflower'
(19, 1), (19, 1), -- Two copies for 'Moby Dick'
(3, 1), (3, 1), (3,2); -- Three copies for 'Pride and Prejudice'

INSERT INTO status_loan (name, description)
VALUES 
('ON LOAN', 'The book copy is currently on loan to a user'),
('Expired', 'The loan period has expired and the book copy is overdue'),
('Finished', 'The loan has been completed and the book copy has been returned');

INSERT INTO loan (user_id, copy_id, status_loan_id, loan_date, return_date, expiration_date)
VALUES (1, 1, 1,'2025-02-14', '2025-02-20', '2025-03-7');

INSERT INTO loan (user_id, copy_id, status_loan_id, loan_date, expiration_date) 
VALUES (3, 4, 3, '2025-01-01', '2025-02-15');

-- UPDATE INFORMATION
SELECT * FROM user where user.id=4;
UPDATE user
SET mail='mamitis@gmail.com'
where user.id=4;

UPDATE category_book
SET category_id=2
WHERE book_id=19;

UPDATE copy
SET status_copy_id=4
WHERE id=1;

UPDATE loan
SET status_loan_id =3
WHERE id=1;

-- DELETE INFORMATION

DELETE FROM copy
Where book_id=10;

DELETE FROM book
WHERE id=10;

USE library;
SELECT * FROM library;


 

