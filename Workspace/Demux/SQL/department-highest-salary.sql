# Write your MySQL query statement below
select d.Name as Department,e.Name as Employee,e.Salary
from Employee as e,Department as d
where e.DepartmentId=d.Id and
(e.DepartmentId,e.Salary) in
(select DepartmentId,max(Salary)
from Employee 
group by DepartmentId)
order by e.Salary desc