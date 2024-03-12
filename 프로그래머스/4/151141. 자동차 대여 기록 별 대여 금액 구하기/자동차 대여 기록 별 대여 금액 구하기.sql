-- 코드를 입력하세요
SELECT  h.HISTORY_ID as  HISTORY_ID , 

round( (c.DAILY_FEE)*
               (
                 case
                when  (datediff(h.END_DATE ,h.START_DATE))+1<7 then (100-0)
                when  (datediff(h.END_DATE ,h.START_DATE))+1<30 then (100-5)
                when  (datediff(h.END_DATE ,h.START_DATE))+1<90 then (100-8)
                when  (datediff(h.END_DATE ,h.START_DATE))+1>=90 then (100-15)
                end
               )
                /100*((datediff(h.END_DATE ,h.START_DATE))+1) )   as FEE
 
  
from CAR_RENTAL_COMPANY_CAR as c 
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on 
c.CAR_ID=h.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on p.CAR_TYPE =c.CAR_TYPE

where c.CAR_TYPE='트럭'

group by h.HISTORY_ID 


order by FEE desc, h.HISTORY_ID desc