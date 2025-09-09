select factory_id, factory_name, address
from food_factory
where substr(address, 1, 3) like '강원도'