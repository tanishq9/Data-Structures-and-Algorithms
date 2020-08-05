# Write your MySQL query statement below
select distinct t1.Num as ConsecutiveNums from Logs as t1,Logs as t2,Logs as t3
where t1.Id+1=t2.Id and t1.Id+2=t3.Id and t1.Num=t2.Num and t2.Num=t3.Num