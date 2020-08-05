-- 3 ways
Select reviewer_name from reviewers 
    where reviewer_id in (select reviewer_id from ratings where reviewer_stars is null)

SELECT reviewer_name from reviewers as r,ratings as rt
WHERE r.reviewer_id=rt.reviewer_id and rt.reviewer_stars IS NULL;

SELECT reviewers.reviewer_name from reviewers natural join ratings where ratings.reviewer_stars IS NULL;
