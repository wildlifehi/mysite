-- select

select * from user;

select * from guestbook;

select * from board;

-- update user set password = '123' where name = 'park';

-- insert into user values(null, 'kim', 'kim@naver.com', '123', 'male' ,now());

-- select no, title, contents, hit, reg_date, g_no, o_no, depth, user_no
-- from board;

select board.no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no, user.name
from board, user
order by reg_date desc;

insert into board values(null, '글제목2', '글내용2', 1, now(), 1, 1, 1, 2 );
