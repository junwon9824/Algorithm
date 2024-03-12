# -- 코드를 입력하세요
# SELECT
# # distinct CART_ID
# *
# from CART_PRODUCTS 

# # where  CART_ID in (  

# #     select 
# #     CART_ID
# #     from
# #     CART_PRODUCTS 
# #     where
# #     NAME = 'Milk'
# # ) and

# #  CART_ID in (  

# #     select 
# #     CART_ID
# #     from
# #     CART_PRODUCTS 
# #     where
# #     NAME = 'Milk'
# # ) 
 
 
# order by  CART_ID asc 

-- 코드를 입력하세요
SELECT CART_ID

from CART_PRODUCTS 

where  NAME in ( 'Yogurt','Milk') 

GROUP BY CART_ID

HAVING COUNT(DISTINCT NAME)=2
 
order by  CART_ID