select d.id, d.email, d.first_name, d.last_name
from developers d
where
    d.skill_code & (select code from skillcodes where name like 'C#')
or
    d.skill_code & (select code from skillcodes where name like 'Python')
order by d.id