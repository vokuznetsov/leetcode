-- 1393. Capital Gain/Loss
-- https://leetcode.com/problems/capital-gainloss/

SELECT stock_name,
       SUM(IF(operation = 'BUY', -price, price)) as capital_gain_loss
FROM Stocks
GROUP BY stock_name;