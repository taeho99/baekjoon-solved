select round(avg(daily_fee), 0) "AVERAGE_FEE"
from car_rental_company_car
where car_type='SUV';