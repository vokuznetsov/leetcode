-- 196. Delete Duplicate Emails
-- https://leetcode.com/problems/delete-duplicate-emails/

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