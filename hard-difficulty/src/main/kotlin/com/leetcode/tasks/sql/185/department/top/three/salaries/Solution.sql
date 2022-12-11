-- 185. Department Top Three Salaries
-- https://leetcode.com/problems/department-top-three-salaries/

SELECT
       d.name   as Department,
       e.name   as Employee,
       e.salary as Salary
FROM (
         SELECT departmentId,
                name,
                salary,
                DENSE_RANK() over (PARTITION BY departmentId ORDER BY departmentId, salary DESC) as dr
         FROM Employee
     ) as e
         LEFT JOIN Department d ON e.departmentId = d.id
WHERE e.dr <= 3;