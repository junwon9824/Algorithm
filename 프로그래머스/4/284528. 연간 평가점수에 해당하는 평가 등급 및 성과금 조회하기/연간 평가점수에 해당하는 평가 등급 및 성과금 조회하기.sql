-- 코드를 작성해주세요
select g.EMP_NO
EMP_NO	, e.EMP_NAME as  EMP_NAME	,
case when avg(SCORE)>=96 
then 'S' 
when avg(SCORE)>=90 
then 'A'
when avg(SCORE)>=80 
then 'B' 
else 'C'
end

as GRADE	, 

case when avg(SCORE)>=96 
then 
 sal * 20 /100 
when avg(SCORE)>=90 
then sal * 15 /100 
when avg(SCORE)>=80 
then sal * 10 /100 
else 0
end

as BONUS

from
HR_GRADE g

join HR_EMPLOYEES e  on g.EMP_NO=e.EMP_NO

group by  e.EMP_NO ,EMP_NAME

order by g.EMP_NO asc

