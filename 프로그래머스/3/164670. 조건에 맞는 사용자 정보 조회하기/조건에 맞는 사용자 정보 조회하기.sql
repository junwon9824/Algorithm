-- 코드를 입력하세요
SELECT board.writer_id as USER_ID  , user2.nickname as NICKNAME  ,

concat(user2.city," ",user2.STREET_ADDRESS1," ",user2.STREET_ADDRESS2) as 전체주소,

concat(substr(user2.TLNO,1,3),"-",substr(user2.TLNO,4,4) ,'-',right(user2.TLNO,4) ) as 전화번호


from USED_GOODS_BOARD board    join  USED_GOODS_USER user2 
on board.writer_id=user2.user_id


group by board.writer_id 
having count(*) >= 3


order by user2.user_id desc