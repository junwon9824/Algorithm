-- 코드를 작성해주세요
with f as (
select sum(CODE)   code
from
SKILLCODES 
where
category='Front End'
)

select

 case
 
 when
d.SKILL_CODE & (select CODE from f ) and 
d.SKILL_CODE & (select CODE from SKILLCODES where NAME='Python')  
 then 'A'
 
 when
d.SKILL_CODE & (select CODE from SKILLCODES where NAME='C#' )
 then 'B'
 
 
 when
d.SKILL_CODE & (select CODE from f  )
 then 'C'
  
  
 end
 
 as GRADE , 
 ID	 ,
 EMAIL

from
DEVELOPERS d

having
  GRADE IS NOT NULL

order by GRADE , ID asc