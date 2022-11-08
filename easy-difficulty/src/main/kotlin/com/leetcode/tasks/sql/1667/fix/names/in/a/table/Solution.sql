-- 1667. Fix Names in a Table
-- https://leetcode.com/problems/fix-names-in-a-table/

Select
    user_id,
    CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) as name
From Users
Order by user_id

