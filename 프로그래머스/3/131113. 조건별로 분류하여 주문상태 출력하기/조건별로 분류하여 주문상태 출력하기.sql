-- 코드를 입력하세요
SELECT fo.order_id ,fo.product_id , 

date_format(fo.out_date, '%Y-%m-%d') as out_date,

(
    
 case when 
datediff(
out_date , '2022-05-01')<=0 
then '출고완료'

when 
datediff(
out_date , '2022-05-01')>0 
then '출고대기'

else
'출고미정'
end)

 '출고여부'
 
from FOOD_ORDER fo
 
order by  order_id asc

