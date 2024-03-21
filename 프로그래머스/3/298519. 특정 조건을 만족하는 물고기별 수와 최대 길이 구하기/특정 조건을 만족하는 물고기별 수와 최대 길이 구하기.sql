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
    AVG(length) >= 33
ORDER BY
    FISH_TYPE ASC;
