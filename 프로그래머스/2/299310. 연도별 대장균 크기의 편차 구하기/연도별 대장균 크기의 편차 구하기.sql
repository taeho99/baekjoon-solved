select 
    year(differentiation_date) year, 
    (select max(size_of_colony) from ecoli_data where year(differentiation_date) = year(ed.differentiation_date)) - ed.size_of_colony "year_dev",
    id
from ecoli_data ed
order by year, year_dev