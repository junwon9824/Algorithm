-- 코드를 입력하세요

SELECT  user.user_id, user.NICKNAME, sum(board.price) as total_sales

from USED_GOODS_BOARD board join USED_GOODS_USER user

on board.WRITER_ID=user.USER_ID

where board.STATUS='DONE'

group by board.WRITER_ID  

having total_sales>=700000



order by total_sales asc;
