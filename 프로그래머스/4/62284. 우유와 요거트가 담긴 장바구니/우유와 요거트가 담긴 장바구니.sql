-- 코드를 입력하세요
SELECT CART_ID

from CART_PRODUCTS as c

where  NAME in ( 'Yogurt','Milk') 

GROUP BY CART_ID

HAVING COUNT(DISTINCT NAME)=2
# HAVING COUNT(  NAME)=2   
 
order by  CART_ID