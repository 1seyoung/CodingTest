-- 코드를 입력하세요
SELECT COUNT(*) AS twenties_users
FROM USER_INFO
WHERE AGE BETWEEN 20 AND 29
  AND JOINED >= '2021-01-01' AND JOINED < '2022-01-01'