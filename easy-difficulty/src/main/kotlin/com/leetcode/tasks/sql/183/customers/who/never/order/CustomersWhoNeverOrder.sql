-- 183. Customers Who Never Order
-- https://leetcode.com/problems/customers-who-never-order/

SELECT name as `Customers`
FROM Customers c
WHERE id NOT IN (SELECT customerId FROM Orders)