select a.id
from ecoli_data a join ecoli_data b join ecoli_data c
on a.parent_id = b.id and b.parent_id = c.id
where c.parent_id is null
order by a.id