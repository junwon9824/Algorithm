-- 코드를 작성해주세요
select i.ITEM_ID as ITEM_ID	, iTEM_NAME	, RARITY

from ITEM_TREE t join ITEM_INFO  i on t.ITEM_ID=i.ITEM_ID

where  i.ITEM_ID  not in (select PARENT_ITEM_ID  from ITEM_TREE  where PARENT_ITEM_ID is not null ) 


order by ITEM_ID desc

