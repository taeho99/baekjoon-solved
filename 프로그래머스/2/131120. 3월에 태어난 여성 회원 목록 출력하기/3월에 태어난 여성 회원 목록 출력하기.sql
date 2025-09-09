select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d')
from member_profile
where gender like 'W' and month(date_of_birth) like '3' and tlno is not null
order by member_id