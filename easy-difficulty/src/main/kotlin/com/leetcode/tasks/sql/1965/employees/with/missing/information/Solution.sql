-- 1965. Employees With Missing Information
-- https://leetcode.com/problems/employees-with-missing-information/description/

Select
    employee_id
From Employees
Where employee_id NOT IN (SELECT employee_id From Salaries)
UNION
Select
    employee_id
From Salaries
Where employee_id NOT IN (SELECT employee_id From Employees)
ORDER BY employee_id

