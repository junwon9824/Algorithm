-- 코드를 입력하세요
SELECT r.CAR_ID	,r.CAR_TYPE	, round((r.DAILY_FEE)*(100-d.DISCOUNT_RATE)/100 *30) as  FEE

# SELECT *

from  CAR_RENTAL_COMPANY_CAR r left join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on r.CAR_ID=h.CAR_ID

left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN  d on d.CAR_TYPE=r.CAR_TYPE
where 

  r.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE  START_DATE < '2022-12-01' AND END_DATE > '2022-11-01' 
)


# and r.CAR_TYPE='세단' or r.CAR_TYPE='SUV' 

# and date_format(h.START_DATE,'%Y-%m-%d') not between '2022-11-01'
# and '2022-11-30'

# and date_format(h.END_DATE,'%Y-%m-%d') not between '2022-11-01'
# and '2022-11-30'

and d.DURATION_TYPE='30일 이상'	


group by r.CAR_ID

having r.CAR_TYPE IN ('세단', 'SUV') AND fee>=50000 and fee<2000000

order by fee desc, r.CAR_TYPE asc, h.CAR_ID desc
     
     