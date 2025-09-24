select history_id, car_id, DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE,
  DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE,
  CASE
    WHEN DATEDIFF(END_DATE, START_DATE) >=  29 THEN '장기 대여'
    ELSE '단기 대여'
  END AS RENT_TYPE
from car_rental_company_rental_history
where year(start_date) = 2022 and month(start_date) = 9
order by history_id desc