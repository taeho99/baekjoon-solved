select book_id, date_format(published_date, '%Y-%m-%d') "published_date"
from book
where category like '인문' and year(published_date) like '2021'
order by published_date