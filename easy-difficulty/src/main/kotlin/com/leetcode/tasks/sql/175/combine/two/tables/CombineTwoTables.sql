-- 175. Combine Two Tables
-- https://leetcode.com/problems/combine-two-tables/

SELECT firstName,
       lastName,
       city,
       state
FROM Person
         LEFT JOIN Address addr on Person.personId = addr.personId;