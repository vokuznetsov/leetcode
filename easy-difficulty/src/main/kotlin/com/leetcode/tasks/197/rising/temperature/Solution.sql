-- 197. Rising Temperature
-- https://leetcode.com/problems/rising-temperature/

DELETE
FROM Person
WHERE id not in (
    SELECT id
    FROM (
             SELECT min(id) as id
             FROM Person
             GROUP BY Email
         ) as t
)