-- 코드를 입력하세요
SELECT history.CAR_ID , max( case when   
'2022-10-16'  between  date_format(start_date,'%Y-%m-%d') and date_format(end_date,'%Y-%m-%d')
then '대여중' else '대여 가능' end ) as AVAILABILITY 


from CAR_RENTAL_COMPANY_RENTAL_HISTORY history 
 
 group by car_id
 
order by history.car_id desc 