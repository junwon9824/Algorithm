-- 코드를 입력하세요
SELECT ai.ANIMAL_ID,ai.name

from ANIMAL_INS ai join ANIMAL_OUTS ao on ai.ANIMAL_ID=ao.ANIMAL_ID
  
 
  
 order by abs(datediff(ai.datetime,ao.datetime ))  desc
 limit 2