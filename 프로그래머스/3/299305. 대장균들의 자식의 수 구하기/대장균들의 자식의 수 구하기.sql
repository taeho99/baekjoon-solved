select a.id, ifnull(b.child_count, 0) "child_count"
from ecoli_data a
left join
(
    select parent_id, count(id) "child_count"
    from ecoli_data
    where parent_id is not null
    group by parent_id
) b
on a.id = b.parent_id
order by id