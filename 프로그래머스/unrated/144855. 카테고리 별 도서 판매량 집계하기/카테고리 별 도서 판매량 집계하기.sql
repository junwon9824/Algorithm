-- 코드를 입력하세요

SELECT book.category, sum(bs.SALES) as TOTAL_SALES


from BOOK book join BOOK_SALES bs on book.book_id=bs.book_id 

 where bs.SALES_DATE like '2022-01%'

group by book.category 

order by book.category asc