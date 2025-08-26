# WITH recursive recurss AS (
#     -- 1세대: PARENT_ID가 NULL인 개체들
#     SELECT ID, PARENT_ID, 1 AS generation
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL
    
#     UNION 
    
#     -- 자식 개체들을 재귀적으로 찾기
#     SELECT e.ID, e.PARENT_ID, g.generation + 1 as generation
#     FROM ECOLI_DATA e
#     JOIN recurss g ON e.PARENT_ID = g.ID
# )

# # -- 3세대 개체들만 선택
# SELECT id
# FROM recurss
# WHERE generation = 3
# ORDER BY ID;

with recursive rc as (
select   1 as generation , id
from ECOLI_DATA
where PARENT_ID is null
    
union 
select rc.generation+1, e.id
from ECOLI_DATA e  join  rc on 
rc.id=e.PARENT_ID 
    
)

SELECT id
FROM rc
WHERE generation = 3
ORDER BY id;

