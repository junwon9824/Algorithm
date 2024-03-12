-- 코드를 입력하세요
SELECT  ai.ANIMAL_ID  as ANIMAL_ID , ai.ANIMAL_TYPE	as ANIMAL_TYPE ,ai.name	as NAME

from  ANIMAL_INS  ai join ANIMAL_OUTS ao   on  ai.ANIMAL_ID=ao.ANIMAL_ID

where (ai.SEX_UPON_INTAKE  like 'Sprayed%' or ai.SEX_UPON_INTAKE like 'Intact%')  and (ao.SEX_UPON_OUTCOME like 'Neutered%' or ao.SEX_UPON_OUTCOME like 'Spayed%')

order by  ANIMAL_ID asc

