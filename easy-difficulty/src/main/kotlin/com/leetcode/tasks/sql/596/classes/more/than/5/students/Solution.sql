-- 596. Classes More Than 5 Students
-- https://leetcode.com/problems/classes-more-than-5-students/

Select
       class
From Courses
Group by class
HAVING count(student) >= 5


