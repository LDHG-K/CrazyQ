CREATE TABLE Games (id_game  BIGSERIAL NOT NULL, game_date date NOT NULL, total_score int8, player_nickname varchar(30) NOT NULL, PRIMARY KEY (id_game));
CREATE TABLE Players (nickname varchar(30) NOT NULL, last_score int8, best_score int8, PRIMARY KEY (nickname));
CREATE TABLE Questions (id_question  SERIAL NOT NULL, queston varchar(255) NOT NULL, answer_1 varchar(255) NOT NULL, answer_2 varchar(255) NOT NULL, answer_3 varchar(255) NOT NULL, answer_4 varchar(255) NOT NULL, category_id int4 NOT NULL, dificulty int4 NOT NULL, PRIMARY KEY (id_question));
CREATE TABLE Categories (id_category  SERIAL NOT NULL, category_name varchar(255) NOT NULL UNIQUE, PRIMARY KEY (id_category));
CREATE TABLE Dificulties (id_dificultad  SERIAL NOT NULL, dificulty varchar(255) NOT NULL UNIQUE, dificulty_score int8 NOT NULL, PRIMARY KEY (id_dificultad));
CREATE TABLE Rounds (game_id int8 NOT NULL, questions_id int4 NOT NULL, round_number int4, answer_score int4, PRIMARY KEY (game_id, questions_id));
ALTER TABLE Questions ADD CONSTRAINT FKQuestions257206 FOREIGN KEY (category_id) REFERENCES Categories (id_category);
ALTER TABLE Rounds ADD CONSTRAINT FKRounds889847 FOREIGN KEY (game_id) REFERENCES Games (id_game);
ALTER TABLE Rounds ADD CONSTRAINT FKRounds945502 FOREIGN KEY (questions_id) REFERENCES Questions (id_question);
ALTER TABLE Games ADD CONSTRAINT FKGames531897 FOREIGN KEY (player_nickname) REFERENCES Players (nickname);
ALTER TABLE Questions ADD CONSTRAINT FKQuestions822604 FOREIGN KEY (dificulty) REFERENCES Dificulties (id_dificultad);


------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
INSERT INTO public.dificulties(
	id_dificultad, dificulty, dificulty_score)
	VALUES (1, 'EASY', '1000');
	
INSERT INTO public.dificulties(
	id_dificultad, dificulty, dificulty_score)
	VALUES (2, 'MEDIUM', '5000');

INSERT INTO public.dificulties(
	id_dificultad, dificulty, dificulty_score)
	VALUES (3, 'HARD', '10000');
	
INSERT INTO public.dificulties(
	id_dificultad, dificulty, dificulty_score)
	VALUES (4, 'INSANE', '100000');
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
INSERT INTO public.categories(
	id_category, category_name)
	VALUES (1, 'SPANISH');

INSERT INTO public.categories(
	id_category, category_name)
	VALUES (2, 'MATH');

INSERT INTO public.categories(
	id_category, category_name)
	VALUES (3, 'ENGLISH');

INSERT INTO public.categories(
	id_category, category_name)
	VALUES (4, 'DEVELOPER');

INSERT INTO public.categories(
	id_category, category_name)
	VALUES (5, 'SCIENCE');
------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'Cow is...', 'Vaca', 'Caballo', 'Cuervo', 'Araña', 1, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '1 is...', 'Uno', 'Tres', 'Cuatro', 'Diez', 1, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'Up is...', 'Arriba', 'Derecha', 'Abajo', 'Izquierda', 1, 2);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'throw is...', 'Lanzar', 'Recoger', 'Desempolvar', 'Arañar', 1, 3);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'Tolima is...', 'Nombre', 'Departamento', 'Palabra', 'Letra', 1, 4);

INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '2 + 2 =', '4', '6', '8', '10', 2, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '2 x 2 =', '4', '6', '8', '10', 2, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '10/2', '5', '6', '4', '2', 2, 2);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '2 x (10+5)', '30', '25', '35', '25', 2, 3);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '5 x (10/0)', 'Nan', '0', 'INF', '50', 2, 4);

INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'Gato es...', 'CAT', 'COW', 'CROW', 'DOG', 3, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'Perro es...', 'DOG', 'CAT', 'GIRAFFE', 'ELEPHANT', 3, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'did you sleep?', 'no, i did´t', 'thank you', 'yes, and you?', 'what?', 3, 2);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'First', 'st', 'nd', 'th', '´th', 3, 3);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'h r u?', 'how are you?', 'how old are you?', 'how rate you?', 'however it´s fine', 3, 4);

INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'HTML is a lenguage?', 'NO', 'YES', 'MAYBE', 'REALLY?', 4, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '++ means...', '+1', '+2', '-1', '*1', 4, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'DTO is...', 'Data transfer object', 'a class', 'heritance', 'Data trail object', 4, 2);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'extends means...', 'heritance', 'reflection', 'polyform', 'inyection', 4, 3);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'will i pass the challenge?', '!no', 'yes', 'yes', 'yes', 4, 4);

INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'HTML is a lenguage?', 'NO', 'YES', 'MAYBE', 'REALLY?', 4, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( '++ means...', '+1', '+2', '-1', '*1', 4, 1);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'DTO is...', 'Data transfer object', 'a class', 'heritance', 'Data trail object', 4, 2);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'extends means...', 'heritance', 'reflection', 'polyform', 'inyection', 4, 3);
INSERT INTO public.questions(
	 queston, answer_1, answer_2, answer_3, answer_4, category_id, dificulty)
	VALUES ( 'will i pass the challenge?', '!no', 'yes', 'yes', 'yes', 4, 4);

