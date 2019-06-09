SELECT * FROM quiz.category;
insert into category(id, name) values (1, 'Cultura generala');
commit;

SELECT * FROM quiz.question;
insert into question(id, text, category_id) values (1, 'Care este capitala Romaniei?', 1);
commit;

SELECT * FROM quiz.answer;
insert into answer(id, correct, text, question_id, checked) values (1, 0, 'Brasov', 1, 0);
insert into answer(id, correct, text, question_id, checked) values (2, 1, 'Bucuresti', 1, 0);
insert into answer(id, correct, text, question_id, checked) values (3, 0, 'Iasi', 1, 0);
commit;


insert into question(id, text, category_id) values (2, 'Cate culori are semaforul?', 1);
commit;

insert into answer(id, correct, text, question_id, checked) values (4, 0, '5', 2, 0);
insert into answer(id, correct, text, question_id, checked) values (5, 1, '3', 2, 0);
insert into answer(id, correct, text, question_id, checked) values (6, 0, '2', 2, 0);
commit;

insert into question(id, text, category_id) values (3, 'Cine a scris Mizerabilii?', 1);
commit;

insert into answer(id, correct, text, question_id, checked) values (7, 0, 'Liviu Rebreanu', 3, 0);
insert into answer(id, correct, text, question_id, checked) values (8, 1, 'Victor Hugo', 3, 0);
insert into answer(id, correct, text, question_id, checked) values (9, 0, 'Honore de Balzac', 3, 0);
commit;