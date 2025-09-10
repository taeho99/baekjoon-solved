select id, if(size_of_colony <= 100, 'LOW', if(size_of_colony <= 1000, 'MEDIUM', 'HIGH')) "size"
from ecoli_data