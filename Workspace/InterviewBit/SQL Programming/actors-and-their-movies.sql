select distinct m.movie_title
from movies as m, movies_cast as mc -- join movies and movies_cast table on common column i.e movie_id
where m.movie_id=mc.movie_id and
      mc.actor_id in  -- check if any actor of any particular actor has acted in 2 or more movies
      ( select a.actor_id from movies_cast as mc,actors as a 
        where a.actor_id=mc.actor_id
        group by a.actor_id
        having count(*)>=2
      )
-- example table after natural join
-- movie_id actor_id movie_name
--    m1       a1      "abc"
--    m2       a1      "xyz"
--    m1       a2      "abc"

-- now after getting this table, we check (altho we are building this table side by side), but think like this
-- we will be checking for every row if it's actor id i.e the actor has acted in 2 or more films 
-- if yes then include it in final column list
-- here, row 1: a1, its yes so we add "abc" to final list
-- now, row 2: a1, its yes i.e acted in 2 or more films, so add "xyz" to list
-- now, row 3: a2, since this actor has only acted in one film, so we don't add to list