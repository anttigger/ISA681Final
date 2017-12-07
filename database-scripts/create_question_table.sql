create table question_table (
	q_number int(11),
	question varchar(150),
	answer varchar(45),
	answer_format varchar(45)
	category varchar(45)
);

insert into question_table (q_number, question, answer, answer_format, category)
values
(001, 'Who was the first president of the United States?', 'George Washington','first name, last name','history'),
(002, 'What year did America gain its independence from Britain?', '1776','4 numbers','history'),
(003, 'Who is the current President of the United States?', 'Donald Trump','first name, last name','history'),
(004, 'What president during the Louisiana Purchase?', 'Thomas Jefferson','first name, last name','history'),
(005, 'What do we call the first 10 amendments to the constitution?', 'Bill of Rights','3 words','history'),
(006, 'What state is Mount Rushmore located in?', 'South Dakota','','geography'),
(007, 'Death Valley is located in what U.S. state?', 'California','','geography'),
(008, 'What is the capital of Virginia?', 'Richmond','1 word','geography'),
(009, 'What is the tallest mountain in the U.S.?', 'Mount McKinley','2 words hint(Mount __)','geography'),
(010, 'What is the smallest U.S. state?', 'Rhode Island','','geography'),
(011, 'What sport gives a player 3 strikes before they are out?', 'Baseball','1 word','sports'),
(012, 'What sport has the championship of the Super Bowl?', 'Football','1 word','sports'),
(013, 'What golfer has won the most major victories?', 'Jack Nicklaus','name 2 words','sports'),
(014, 'What game uses the word love?', 'Tennis','1 word','sports'),
(015, 'How many players are on the ice per team in an NHL hockey game?', 5 ,'number','sports');