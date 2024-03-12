-- 코드를 입력하세요
SELECT    fp.PRODUCT_ID  as PRODUCT_ID, PRODUCT_NAME as PRODUCT_NAME 
,sum( fp.price *fo.amount ) as  TOTAL_SALES

from  FOOD_PRODUCT  fp join   FOOD_ORDER fo on fp.PRODUCT_ID=fo.PRODUCT_ID

where  date_format( fo.PRODUCE_DATE,'%Y-%m' )='2022-05'

group by  PRODUCT_ID

order by TOTAL_SALES  desc , PRODUCT_ID asc