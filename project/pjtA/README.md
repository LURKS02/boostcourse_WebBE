# Date와 Timestamp

* date(java.sql.Date) : 연, 월, 일 저장 (SQL의 Date 필드)
* time(java.sql.Time) : 시, 분, 초 저장 (SQL의 Time 필드)
* timestamp(java.sql.Timestamp) : nanosecond 단위의 시간 저장 (SQL의 Timestamp 필드)

java.util.Date 형식의 데이터와 호환하기 위하여 java.sql.Date를 사용하였지만 시분초가 표기되지 않았다.
```java
//select
java.util.Date utilDate = new java.util.Date(rs.getDate(4).getTime());

//insert
ps.setDate(4, new java.sql.Date(businessCard.getCreateDate().getTime()));
```
결과 : BusinessCard{name='홍길동', phone='010-0000-0001', companyName='커넥트', createDate=Fri Jul 17 09:00:00 KST 2020}
***
시, 분, 초 단위까지 정확하게 표현하기 위해 Timestamp형식을 이용하였다.

```java
//select
java.util.Date utilDate = rs.getTimestamp(4);

//insert
ps.setTimestamp(4, new Timestamp(businessCard.getCreateDate().getTime()));
```
결과 : BusinessCard{name='홍길동', phone='010-0000-0001', companyName='커넥트', createDate=2020-07-17 14:46:52.0}
시분초까지 제대로 표시되는 것을 확인할 수 있다.
