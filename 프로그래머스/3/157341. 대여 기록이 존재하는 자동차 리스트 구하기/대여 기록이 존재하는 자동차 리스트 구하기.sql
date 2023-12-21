-- 코드를 입력하세요
SELECT distinct car.car_id  

from CAR_RENTAL_COMPANY_CAR car join CAR_RENTAL_COMPANY_RENTAL_HISTORY as hi

on car.CAR_ID=hi.car_id

where  car.car_type='세단'and 
 
# substr(rental.start_date,5,2)='10'
# month(start_date)=10

SUBSTR(hi.start_date, 6, 2) = '10'
 
order by car.car_id desc