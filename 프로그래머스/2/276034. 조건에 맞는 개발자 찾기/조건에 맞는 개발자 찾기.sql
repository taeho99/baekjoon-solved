select d.id, d.email, d.first_name, d.last_name
from developers d
where
    bin(d.skill_code) like (
        select concat('%', replace(bin(code), '0', '_'))
        from skillcodes
        where name in ('Python')
    ) or
    bin(d.skill_code) like (
        select concat('%', replace(bin(code), '0', '_'))
        from skillcodes
        where name in ('C#')
    )
order by d.id

