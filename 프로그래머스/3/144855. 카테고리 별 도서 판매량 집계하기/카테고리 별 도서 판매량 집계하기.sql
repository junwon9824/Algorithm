select b.CATEGORY ,  sum(bs.SALES)  as TOTAL_SALES

from BOOK b join BOOK_SALES bs on
 b.BOOK_ID= bs.BOOK_ID 

where  year(bs.SALES_DATE)=2022
and month(bs.SALES_DATE) =1

group by b.CATEGORY 
order by b.CATEGORY asc