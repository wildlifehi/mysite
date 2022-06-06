-- select

select * from user;

-- insert into user values (null, '테스트용','test', 'test', 'male', now());

select * from guestbook;

select * from board;

-- update user set password = '123' where name = 'park';

-- insert into user values(null, 'kim', 'kim@naver.com', '123', 'male' ,now());

-- select no, title, contents, hit, reg_date, g_no, o_no, depth, user_no
-- from board;

select board.no, title, contents, hit, date_format(reg_date, '%Y/%m/%d %H:%i:%s') as reg_date, g_no, o_no, depth, user_no, name
from board, user
where board.user_no = user.no
order by g_no desc, o_no ;

insert into board values(null, '하이5', '글내용2', 1, now(), 2, 3, 1, 2 );
-- insert into board values(null, 'title', 'contents', 0, now(), (select if(g_no is null, 1, max(g_no) + 1 )
-- from board as a) ,0 ,0, 1);
-- delete from board where no= 2;
update board set title = '바꿈1', contents = '바꿈2' where no = 19;



insert into board values(null, ?, ?, 0, now(), ?, if( ? !=0 , ?, (select max(o_no) from board as a where g_no = ?) + 1) , ?+1, ?);