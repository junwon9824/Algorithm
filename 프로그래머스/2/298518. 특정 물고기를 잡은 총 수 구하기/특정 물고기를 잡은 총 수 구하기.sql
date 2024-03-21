-- 코드를 작성해주세요
select ( count( fi.id) ) FISH_COUNT
# select *

from
FISH_INFO  fi join FISH_NAME_INFO n on fi.FISH_TYPE=n.FISH_TYPE

where ( n.FISH_NAME='BASS' or n.FISH_NAME='SNAPPER' ) 

