select info.rest_id, info.rest_name, info.food_type, info.favorites, info.address, round(avg(review.review_score), 2) "score"
from rest_info info join rest_review review
on info.rest_id = review.rest_id
where info.address like '서울%'
group by info.rest_id, info.rest_name, info.food_type, info.favorites, info.address
order by score desc, favorites desc