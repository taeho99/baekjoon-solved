select a.id, b.fish_name, b.length
from fish_info a join 
(
    select fni.fish_type, fni.fish_name, max(fi.length) length
    from fish_info fi join fish_name_info fni
    on fi.fish_type = fni.fish_type
    group by fni.fish_type, fni.fish_name
) b
on a.fish_type = b.fish_type and a.length = b.length
order by a.id