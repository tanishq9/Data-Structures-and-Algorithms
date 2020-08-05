-- 3 ways
select movies.movie_title,
    movies.movie_year,
    concat(directors.director_first_name,directors.director_last_name) as director_name,
    concat(actors.actor_first_name,actors.actor_last_name) as actor_name,
    movies_cast.role 
from actors,movies_cast,movies,movies_directors,directors
where actors.actor_id=movies_cast.actor_id and
      movies_cast.movie_id=movies.movie_id and
      movies.movie_id=movies_directors.movie_id and
      movies_directors.director_id=directors.director_id 
order by movies.movie_time asc
limit 1;


select movies.movie_title,
    movies.movie_year,
    concat(directors.director_first_name,directors.director_last_name) as director_name,
    concat(actors.actor_first_name,actors.actor_last_name) as actor_name,
    movies_cast.role 
from actors,movies_cast,movies,movies_directors,directors
where actors.actor_id=movies_cast.actor_id and
      movies_cast.movie_id=movies.movie_id and
      movies.movie_id=movies_directors.movie_id and
      movies_directors.director_id=directors.director_id and
      movies.movie_time=(select min(movie_time) from movies)


select movies.movie_title,
    movies.movie_year,
    concat(directors.director_first_name,directors.director_last_name) as director_name,
    concat(actors.actor_first_name,actors.actor_last_name) as actor_name,
    movies_cast.role 
from actors,movies_cast,movies,movies_directors,directors
where actors.actor_id=movies_cast.actor_id and
      movies_cast.movie_id=movies.movie_id and
      movies.movie_id=movies_directors.movie_id and
      movies_directors.director_id=directors.director_id 
-- incase we have multiple movies having lowest time then use group by clause
group by movies.movie_time
having movies.movie_time=(select min(movie_time) from movies)
