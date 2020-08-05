CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      # Using correlated subquery logic
      select distinct Salary from Employee as e1
      where N-1=(select count(distinct e2.Salary) from Employee as e2 where e1.Salary<e2.Salary)
  );
END