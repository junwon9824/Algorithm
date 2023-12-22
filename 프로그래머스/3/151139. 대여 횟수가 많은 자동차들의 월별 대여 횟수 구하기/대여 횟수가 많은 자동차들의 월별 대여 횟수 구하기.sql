-- 코드를 입력하세요

SELECT month(START_DATE) as  MONTH , CAR_ID ,  COUNT(*) as RECORDS

from  CAR_RENTAL_COMPANY_RENTAL_HISTORY 
  
where CAR_ID in(
    
select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
    GROUP BY CAR_ID
     HAVING COUNT(CAR_ID) >= 5
    
)
 
 and ( date_format(START_DATE ,'%Y-%m') between '2022-08' and '2022-10' )
  
group by CAR_ID,MONTH
 HAVING  RECORDS>0

order by MONTH asc , CAR_ID desc

