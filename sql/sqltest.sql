-- select

select * from user;

select * from guestbook;

select * from board;

-- update user set password = '123' where name = 'park';

-- insert into user values(null, 'kim', 'kim@naver.com', '123', 'male' ,now());

-- select no, title, contents, hit, reg_date, g_no, o_no, depth, user_no
-- from board;

select no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no
from board
order by reg_date desc;