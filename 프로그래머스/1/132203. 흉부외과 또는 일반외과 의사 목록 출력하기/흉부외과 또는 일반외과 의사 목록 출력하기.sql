-- 코드를 입력하세요
select DR_NAME, DR_ID, MCDP_CD, date_format(HIRE_YMD, '%Y-%m-%d') "HIRE_YMD"
from doctor
where mcdp_cd in ('cs', 'gs')
order by hire_ymd desc, dr_name;