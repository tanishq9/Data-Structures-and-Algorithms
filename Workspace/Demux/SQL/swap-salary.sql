# Write your MySQL query statement below
# using sql case in combination with update and set
update salary 
set sex = case -- we are here saying that sex column value is a case i.e it depends on certain criteria, which will tell using when and then  
    when sex='m' then 'f'
    when sex='f' then 'm'
    end;