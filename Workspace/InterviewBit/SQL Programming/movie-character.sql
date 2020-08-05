select concat(d.director_first_name,d.director_last_name) as director_name,
       m.movie_title
from movies_cast as mc, movies as m, movies_directors as md, directors as d
where mc.movie_id=m.movie_id and
      m.movie_id=md.movie_id and
      md.director_id=d.director_id and
      mc.role = 'SeanMaguire'