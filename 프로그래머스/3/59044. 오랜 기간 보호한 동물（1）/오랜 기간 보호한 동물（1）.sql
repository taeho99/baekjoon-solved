select tb1.name "NAME", tb1.datetime "DATETIME"
from
    (select * from animal_ins) tb1
left join
    (select a.*
    from animal_ins a join animal_outs b
    on a.animal_id = b.animal_id) tb2
on tb1.animal_id = tb2.animal_id
where tb2.animal_id is null
order by tb1.datetime
limit 3