-- 코드를 입력하세요
SELECT year(sales_date) as YEAR	,  month(SALES_DATE)  as  MONTH 
,( count( distinct USER_ID) ) as PUCHASED_USERS , 
round( count( distinct USER_ID)  / (select  count(*)  from user_info where year(joined) ='2021')  , 1)  as PUCHASED_RATIO
  
from  ONLINE_SALE 

 where user_id in (select user_id from user_info where year(joined) = '2021')


group by YEAR,MONTH

order by  YEAR asc ,  MONTH asc