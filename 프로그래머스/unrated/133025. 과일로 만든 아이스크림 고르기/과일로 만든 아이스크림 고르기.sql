-- 코드를 입력하세요
SELECT fh.flavor

from FIRST_HALF as fh join ICECREAM_INFO as i on fh.flavor=i.flavor

where fh.TOTAL_ORDER>3000 and i.INGREDIENT_TYPE='fruit_based'
