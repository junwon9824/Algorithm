-- 코드를 입력하세요
SELECT PRODUCT_ID 	,PRODUCT_NAME	,PRODUCT_CD	,CATEGORY	,PRICE

from FOOD_PRODUCT 

where price in (
select
    max(price)
    from
    FOOD_PRODUCT
)
  