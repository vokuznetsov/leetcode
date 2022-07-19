-- 181. Employees Earning More Than Their Managers
-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT e.name as Employee
FROM Employee e
         INNER join Employee e2 on e.managerId = e2.id
WHERE e.salary > e2.salary;