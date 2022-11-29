-- 1795. Rearrange Products Table
-- https://leetcode.com/problems/rearrange-products-table/


Select product_id, 'store1' as 'store', store1 as 'price' From Products Where store1 IS NOT NULL
UNION
Select product_id, 'store2' as 'store', store2 as 'price' From Products Where store2 IS NOT NULL
UNION
Select product_id, 'store3' as 'store', store3 as 'price'  From Products Where store3 IS NOT NULL
