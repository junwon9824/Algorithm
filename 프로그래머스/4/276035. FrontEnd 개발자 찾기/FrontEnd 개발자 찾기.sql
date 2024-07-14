-- 코드를 작성해주세요
select ID	
,EMAIL
,FIRST_NAME	
,LAST_NAME


from
DEVELOPERS  d

where SKILL_CODE &(select sum(code)   from SKILLCODES where category='Front End')>0 

order by ID asc