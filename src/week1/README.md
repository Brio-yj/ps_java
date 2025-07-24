# 입력 받기
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //입력 시작

int n = Integer.parseInt(br.readLine()); //정수 
String s = br.readLine(); //문자열

## 하나의 줄에 공백을 기준으로 입력 받기
StringTokenizer st = new StringTokenizer(br.readLine());

int n = Integer.parseInt(st.nextToken());

int m = Integer.parseInt(st.nextToken());
## 입력이 몇개인지 모를때
while((line=br.readLine())!=null && !line.trim().isEmpty()) //공백만 입력들어 온거 필요없을때

while((line=br.readLine())!=null){if(line.isEmpty)~} //공백만 입력들어 사용해야할때

## 갯수 모르는데 특정 기호를 구분으로 입력 들어올때 
while(line=br.readLine()!=null && !line.trim().isEmpty())

StringTokenizer st = new StringTokenizer(line,",") // ,로 구분시켜서 입력받은거 정리

while(st.hasMoreToken)  { int n = Integer.parseInt(st.nextToken.trim());}   //토큰 다 뽑아내기

우선 String으로 받고 st로 넘긴다

# 문자열

## 문자열의 각 원소에 접근해야 할때
String s = new String();

for(~) s.charAt(i)

StringBuilder sb = new StringBuilder(br.readLine());

sb.insert(),sb.append(),sb.reverse(),sb.replace() 등등

#List 사용하기
List.add(val),List.add(idx,val)

List.get(idx)-값 반환,List.indexOf(val)-첫 위치,List.lastIndexof(val)-마지막 위치


# 다시 풀거
9906, 2559(큰돌식 풀이로 풀어보기-최솟값 정의, psum사용)

## 소소팁 정리
parseInt()는 Integer 클래스 안에 정의된 
static method (클래스 메서드)
->Integer.parseInt() 이렇게 쓸 수 밖에 없다

stream() 메서드는 리스트를 Stream<Integer> 형태로 변경한다

스트림(Stream)은 자바 8부터 도입된 함수형 데이터 처리 방식

Character.isDigit(charAt(idx))

# 2309
BufferedReader br -> 반복해서 계속 만들면 안된다

stream(ARR).sum();
배열 → 스트림 → 합계 구하기	

stream()은 객체 반환, sum()은 그 객체의 메서드

sort(ARR);

배열을 오름차순으로 정렬 sort()는 바로 동작하는 정적(static) 메서드


객체마다 값이 다르고, 그 상태를 활용해야 할 때

-> 인스턴스 메서드 : 각 객체의 고유 정보 필요

모든 객체와 무관한 계산이나 유틸 기능

->정적 메서드 : 객체 생성 없이 공통 작업 가능

System.exit(0);

---

int[] a = {1, 2, 3}; 값과 함께 선언 시 new 생략 가능

int[] a = new int[3]; 크기만 선언할 때는 반드시 필요

int[] arr = {1, 2, 3};
이렇게 작성하면, 컴파일러는 자동으로 new int[]{1, 2, 3}으로 변환

→ 리터럴 방식은 선언과 동시에 쓸 때만 가능

자바는 정적 타입 언어 

타입과 크기 등을 컴파일 시점에 명확히 알아야 한다.

{}만 단독으로 썼을 때는 어떤 타입인지 명확하지 않아서 new와 타입을 명시해야만 유효한 표현이 된다.

리터럴 = 말 그대로 코드에서 값을 직접 표현한것

---

# 10808

### 카운팅은 map or array, 문자열 = map, 숫자 카운팅 = array

charAt(idx) -> 문자열 특정 위치에 있는 문자 반환 메서드

String은 객체라서 메서드를 통해 접근 해야 한다(배열 느낌 아님)

시간 문제는 대부분 이상 미만이다

# 10808

### StringBuilder

원래 문자열은 한번 생성하면 수정할 수 없다. 만약 수정이나 추가작업이 필요한 경우 StringBuilder를 활용한다
 
# 1159

명시적 변환 사용법 : (char)('a'+i)

# 11655

StringBuilder.setCharAt(idx,char)

Character.isUpperCase(c)

Character.isLowerCase(c)

### 사칙연산 문제 -> 나머지 사용해서 풀기

# 9996
 
split() 안에 delemeter 넣을때 특수문자들은 \\ 이거 붙여서 사용해야 한다

문자열 문제는 일단 substr, find, reverse 생각해야 한다

substr -> substring()	

// s.substring(시작인덱스) → 시작 인덱스부터 끝까지

// s.substring(시작인덱스, 끝인덱스) → 시작부터 (끝-1)까지

---
find -> indexOf()

// s.indexOf('o')

// 없으면 -1 리턴

---
reverse-> StringBuilder.reverse()	

# 2559
 
삼항연산자 -> if 사용안한다  => max = (a>b) ? a : b

## 최댓값 구해라 -> 최솟값 먼저 구하기, 최솟값 구해라 -> 최댓값 먼저 구하기 
## prefixSum : 배열 인덱스 1 부터 시작, 크기 = n+1

# 1620
class 만들어서 사용할거면 1.main 클래스 안에서 static 클래스로 사용 or 2. main 클래스 밖에서 만들어서 사용 보통은 main안에서 사용하는듯

## map
자바에서 키를 이용해서 값을 부르는건 ok, 값을 이용해서 키를 부르는 건 no 

이거 해결하기 위해서 맵을 생성할때 2개를 만든다 -> map, reverseMap

| 메서드                    | 설명             |
|:-----------------------|:---------------|
| `put(key, value)`      | 키-값 추가         |
| `get(key)`             | 키로 값 가져오기      |
| `remove(key)`          | 키-값 삭제하기       |
| `containsKey(key)`     | 특정 키가 존재하는지 확인 |
| `containsValue(value)` | 특정 값이 존재하는지 확인 |

---
int[] arr = new int[26];
문자열 탐색하면서 접근할땐 s.charAt()
핵심은 어떤작업을 동시에 할수 있을지 생각하는것!!

---
# 1213
입력은 String으로 받고
문자열 자르고 분리 등 조작할때는 StringBuilder로 다시 초기화 해서 사용
항상 동작을 동시에 하는 방법을 생각하자

# 1629
재귀함수 꿀팁
1. f(n) 이게 정확히 뭔지, 즉 문제가 정확히 먼지 파악
2. 기저 사례 즉, 베이스 컨디션 파악
3. f(n)을 f(n-1)과 같이 어떻게 표현할지 고민
4. 코드 만들기

# 4375

