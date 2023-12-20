-- 코드를 입력하세요
SELECT concat('/home/grep/src/',f.board_id,'/',f.file_id,f.file_name,f.file_ext) as FILE_PATH
from USED_GOODS_BOARD b 
 join USED_GOODS_FILE f on b.board_id=f.board_id
where VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
order by f.file_id desc