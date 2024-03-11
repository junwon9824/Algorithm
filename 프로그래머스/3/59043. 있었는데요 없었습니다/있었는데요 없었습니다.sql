-- 코드를 입력하세요
# SELECT *
SELECT ai.ANIMAL_ID , ai.NAME

from ANIMAL_INS ai   join ANIMAL_OUTS ao on ai.animal_id=ao.animal_id

# where datediff(ai.datetime,ao.datetime)>0
WHERE ai.DATETIME > ao.datetime

order by ai.datetime asc
