-- 1527. Patients With a Condition
-- https://leetcode.com/problems/patients-with-a-condition/

Select
    patient_id,
    patient_name,
    conditions
From Patients
WHERE conditions LIKE '% DIAB1%' OR  conditions LIKE 'DIAB1%'

