# 부모의 형질을 모두 가지는 대장균 찾기
같은 테이블끼리 조인해야한다 = 셀프조인

from table t1
join table t2
on t1.id = t2.id

where(t1.id & t2.id)=t1.id -> 칼럼값이 서로 동일한지 확인할때, 또는 2번이 1번을 포함하고 있는지 확인할때 사용

# 연도별 대장균 크기의 편차 구하기
윈도우 함수 사용법 : window_function(parameter) over(partition by~ order by~)

기본적으로 SELECT, ORDER BY에서 사용된다

YEAR(~) -> 날짜 형식이 들어오면 YEAR리턴