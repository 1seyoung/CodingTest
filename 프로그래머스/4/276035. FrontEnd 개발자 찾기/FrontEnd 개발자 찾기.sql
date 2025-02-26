-- 코드를 작성해주세요
select DISTINCT de.ID , de.EMAIL, de.FIRST_NAME , de.LAST_NAME 
from developers de
join skillcodes sk on (de.skill_code & sk.code) != 0
where sk.CATEGORY = 'Front End'
order by de.id asc;