# SQL 질의어 간단 정리

```sql
create table User(
id Long autoincremnet,
name varchar(10),
city varchar(10),
constraint user_pk primary key (id)
);
```

---

## constraint

- primary key
- unique key
- not null
- check
- foreign key

---

```sql
insert into User (name, city) values ('jsh', 'seoul');
insert into User (name, city) values ('cwj', 'ansan');
insert into User (name, city) values ('yjs', 'ansan');
insert into User (name, city) values ('kyu', 'newjurgy');
insert into User (name, city) values ('don', 'Gyeongi');
insert into User (name, city) values ('jsh', 'ansan');

select * from User where name = 'jsh'; ==> 1
select * from User where name = 'jsh' and city = 'ansan'; ==? 6
```

## SELECT 문의 응용조작을 배워보자

```sql
SELECT * FROM city where contryCode = 'KOR' order by population desc;
```

- desc : 내림차순으로 정렬하기 위해서 있는 Query 문

### 정렬 수행 시 문제점

- ORDER BY 에 의한 정렬을 수행할 때 행의 순서를 확실히 같게 하려면 행의 정렬키를 한 가지 의미로 정해야 합니다. 바꿔말하면, 정렬키가 같은 값은 행의 복수개 존재한다면, 그 행들의 순서는 일정하지 않습니다.

```sql
select * from User order by name;
```

### 테이블을 요약하는 함수

- **COUNT** : 테이블의 행수를 알려주는 함수
- **SUM** : 테이블의 수치 데이터를 합계하는 함수
- **AVG** : 테이블의 수치 데이터 평균을 구하는 함수
- **MAX** : 테이블의 임의열 데이터 중 최대값을 구하는 함수
- **MIN** : 테이블의 임의열 데이터 중 최소값을 구하는 함수

이러한 집약함수는 기본적으로 NULL 을 제외하고 집계하는데, COUNT 함수만은 'COUNT(*)' 로 표기하여 NULL 을 포함한 전체 행을 집계합니다. 

```sql
mysql> select count(*) from User;
+----------+
| count(*) |
+----------+
|        6 |
+----------+
1 row in set (0.01 sec)
```

```sql
mysql> select min(name) from User;
+-----------+
| min(name) |
+-----------+
| cwj       |
+-----------+
1 row in set (0.00 sec)
```

```sql
mysql> select * from User;
+----+------+----------+
| id | name | city     |
+----+------+----------+
|  1 | jsh  | seoul    |
|  2 | cwj  | ansan    |
|  3 | yjs  | ansan    |
|  4 | kyu  | newjurgy |
|  5 | don  | Gyeongi  |
|  6 | jsh  | ansan    |
+----+------+----------+
6 rows in set (0.00 sec)

mysql> select group_concat(name) from User;
+-------------------------+
| group_concat(name)      |
+-------------------------+
| jsh,cwj,yjs,kyu,don,jsh |
+-------------------------+
1 row in set (0.00 sec)

mysql> select group_concat(DISTINCT name) from User;
+-----------------------------+
| group_concat(DISTINCT name) |
+-----------------------------+
| cwj,don,jsh,kyu,yjs         |
+-----------------------------+
1 row in set (0.01 sec)

mysql> select DISTINCT name from User;
+------+
| name |
+------+
| jsh  |
| cwj  |
| yjs  |
| kyu  |
| don  |
+------+
5 rows in set (0.00 sec)
```

### Group_concat

- 문자열에 대한 집약함수는 SQL 표준에는 없으나 MYSQL 에는 'GROUP_CONCAT' 함수가 있습니다.
- SUM 함수는 **수치**에 대한 집계를 더해 수행하지만, **GROUP_CONCAT** 함수는 **문자열** 에 대한 집계를 **문자열의 결합** 으로 수행합니다. 따라서 콤마로 구분되는 매우 긴 데이터를 결과로 돌려줍니다.

```sql
mysql> select group_concat(name) from User;
+-------------------------+
| group_concat(name)      |
+-------------------------+
| jsh,cwj,yjs,kyu,don,jsh |
+-------------------------+
1 row in set (0.01 sec)
```

**jsh,cwj,yjs,kyu,don,jsh** 라는 문자열로 돌려준다. 음 만약에 우리가 JPA 같은걸 이용할때 받아서 Split 하면 좋을 것 같다.

### 데이터를 그룹으로 나누는 GROUP BY

- 지금까지 집약함수는 대상이 되는 데이터 전체를 범위로 집약했는데, 대상이 되는 데이터를 몇 개의 그룹으로 나눠서 집약하는 것도 가능합니다. 그룹을 나눌 때는 나누는 키가 되는 열을 지정합니다. 예를 들어, **행정구역** 마다 **국가** 마다 집약하는 식입니다. **아래와 같이 Having 으로 조건식도 걸어서 분류할 수 있다.**

```sql
SELECT ~ FROM 테이블명 GROUP BY 열명1 [, 열명2, ...]
```

```sql
mysql> select name,count(*) from User group by name;
+------+----------+
| name | count(*) |
+------+----------+
| jsh  |        2 |
| cwj  |        1 |
| yjs  |        1 |
| kyu  |        1 |
| don  |        1 |
+------+----------+
5 rows in set (0.00 sec)
```

```sql
mysql> select name,count(*) from User group by name having count(*)=1;
+------+----------+
| name | count(*) |
+------+----------+
| cwj  |        1 |
| yjs  |        1 |
| kyu  |        1 |
| don  |        1 |
+------+----------+
4 rows in set (0.00 sec)
```

## 데이터를 갱신 / 삽입 / 제거해 보자.

```sql
mysql> select * from User;
+----+------+----------+
| id | name | city     |
+----+------+----------+
|  1 | jsh  | seoul    |
|  2 | cwj  | ansan    |
|  3 | yjs  | ansan    |
|  4 | kyu  | newjurgy |
|  5 | don  | Gyeongi  |
|  6 | jsh  | ansan    |
+----+------+----------+
6 rows in set (0.00 sec)
```

```sql
mysql> update User set name = 'roach'
    -> where city = 'seoul' and name = 'jsh';
```

```sql
mysql> select * from User;
+----+-------+----------+
| id | name  | city     |
+----+-------+----------+
|  1 | roach | seoul    |
|  2 | cwj   | ansan    |
|  3 | yjs   | ansan    |
|  4 | kyu   | newjurgy |
|  5 | don   | Gyeongi  |
|  6 | jsh   | ansan    |
+----+-------+----------+
6 rows in set (0.00 sec)
```

- update 와 set 을 통해서 column 을 update 해보자!

```sql
mysql> delete from User where name = 'roach';
Query OK, 1 row affected (0.01 sec)

mysql> select * from User;
+----+------+----------+
| id | name | city     |
+----+------+----------+
|  2 | cwj  | ansan    |
|  3 | yjs  | ansan    |
|  4 | kyu  | newjurgy |
|  5 | don  | Gyeongi  |
|  6 | jsh  | ansan    |
+----+------+----------+
5 rows in set (0.00 sec)
```

```sql
mysql> create Table Usercopy ( id integer(10), name varchar(10), city varchar(10) );
Query OK, 0 rows affected, 1 warning (0.03 sec)
```

### Insert Into 를 통해서 다른 테이블값 copy 하기

- Usercopy 테이블은 User 테이블과 동일한 구조이다.
- User 테이블의 값을 가져오기 위해서 아래와 같은 쿼리를 날린다.

```sql
mysql> insert into Usercopy select * from User;
Query OK, 5 rows affected (0.01 sec)
Records: 5  Duplicates: 0  Warnings: 0

mysql> select * from Usercopy;
+------+------+----------+
| id   | name | city     |
+------+------+----------+
|    2 | cwj  | ansan    |
|    3 | yjs  | ansan    |
|    4 | kyu  | newjurgy |
|    5 | don  | Gyeongi  |
|    6 | jsh  | ansan    |
+------+------+----------+
5 rows in set (0.00 sec)
```
