-- 코드를 작성해주세요
select  year(DIFFERENTIATION_DATE) YEAR, 
( 
    ( select max(SIZE_OF_COLONY) 
         from ECOLI_DATA 
          where year=year(DIFFERENTIATION_DATE)
         group by year(DIFFERENTIATION_DATE))
    - SIZE_OF_COLONY )
                     as YEAR_DEV ,
                     
     ID

from ECOLI_DATA  as e

order by YEAR , YEAR_DEV