-- 코드를 입력하세요
SELECT ao.ANIMAL_ID ,  ao.NAME

from ANIMAL_INS ai   right join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id 

 where ai.SEX_UPON_INTAKE is null

order by ao.ANIMAL_ID