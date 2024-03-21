SELECT
    COUNT(*) AS FISH_COUNT,
    CASE
        WHEN MAX(length) <= 10 THEN 10
        ELSE MAX(length)
    END 
    
    MAX_LENGTH,
    
    FISH_TYPE
    
FROM
    FISH_INFO
GROUP BY
    FISH_TYPE
    
HAVING
    AVG(case when length<=10 then 10 when length is null then 10 else length end ) >= 33
    
ORDER BY
    FISH_TYPE ASC;