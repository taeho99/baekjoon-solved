select pt_name "PT_NAME", pt_no "PT_NO", gend_cd "GEND_CD", age "AGE", ifnull(tlno, 'NONE') "TLNO"
from patient
where age<=12 && gend_cd like 'W'
order by age desc, pt_name