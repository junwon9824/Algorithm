-- 코드를 작성해주세요

select sum(g.score ) as SCORE,e.EMP_NO as EMP_NO,	EMP_NAME,	POSITION,	EMAIL

from HR_GRADE g join  HR_EMPLOYEES e on g.EMP_NO=e.EMP_NO
where  g.year='2022'

group by e.EMP_NO 
order by  SCORE desc
limit 1

