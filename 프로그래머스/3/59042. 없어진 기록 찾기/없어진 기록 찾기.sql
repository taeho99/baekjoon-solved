select animal_id, name from animal_outs
where animal_id not in (select a.animal_id from animal_ins a
inner join
animal_outs b on a.animal_id = b.animal_id )
