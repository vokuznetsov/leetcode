-- 182. Duplicate Emails
-- https://leetcode.com/problems/duplicate-emails/

SELECT e.name as Employee
FROM Employee e
         INNER join Employee e2 on e.managerId = e2.id
WHERE e.salary > e2.salary;