-- 코드를 작성해주세요

select  t.ITEM_ID as ITEM_ID	,  ITEM_NAME	,  RARITY
 
from ITEM_TREE as t join ITEM_INFO i on t.ITEM_ID=i.ITEM_ID

where PARENT_ITEM_ID is not null and (select RARITY from  ITEM_INFO as ii where t.PARENT_ITEM_ID=ii.ITEM_ID )='RARE' 

order by  t.ITEM_ID desc