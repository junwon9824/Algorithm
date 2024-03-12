set @h=-1;

select (@h :=@h+1)
 as HOUR,
 
(
select
    count(DATETIME)
from
    ANIMAL_OUTS 
where
    hour(DATETIME)=@h
)

COUNT

from
ANIMAL_OUTS 

where @h<23
 
