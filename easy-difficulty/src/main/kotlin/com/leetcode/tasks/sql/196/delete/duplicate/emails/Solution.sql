-- 196. Delete Duplicate Emails
-- https://leetcode.com/problems/delete-duplicate-emails/

-- first variant
DELETE
FROM Person
WHERE id not in (
    SELECT id
    FROM (
             SELECT min(id) as id
             FROM Person
             GROUP BY Email
         ) as t
);

-- second variant
DELETE p1 FROM Person p1, Person p2
WHERE p1.email = p2.email and p1.id > p2.id;