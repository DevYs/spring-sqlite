마이크로 웹서비스를 위한 SpringBoot와 SQLite 연동 템플릿
===============================================


##### 이 예제는 Spring Boot와 SQLite로 소형 웹 애플리케이션을 빠르게 개발을 시작하기 위해 제작되었습니다.
##### Spring Security, Spring OAuth2 등과 같은 보안과 인증 관련 라이브러리는 추가하지 않았습니다.
##### IntelliJ에서 개발되었습니다.


### 주요파일
#### sqlite3
sqlite3 파일은 Spring Boot 구동시 SQLite에 DDL 구문을 실행하기 위해 사용됩니다.

#### create.sql
create.sql은 SQLite에 Table을 생성하기 위한 스크립트 파일입니다.
주로 초기 Table 생성 및 SQLite 설정에 사용됩니다.
Spring Boot가 실행될때마다 매번 실행되기 때문에 일회용 및 Schema를 수정하기 위한 용도로 사용해야 합니다.
예를들어 'CREATE TABLE' 구문에서는 'IF NOT EXISTS'로 Table을 생성하는 것이 좋습니다.

#### sqlite.db
sqlite.db는 예제에서 사용하는 데이터베이스 파일입니다. 파일명이 변경되거나 확장자가 변경되면 해당 예제에서는 사용할 수 없습니다.
데이터베이스를 백업하기 위해서는 해당 파일을 복사하면 됩니다.

### 패키지 및 필요 클래스 설명
대부분의 MVC 패턴의 JDBC 환경에서는 Controller, Service, Mapper, Domain Model 등의 클래스를 작성합니다.
Mapper 클래스의 경우 Spring Boot에서 지원하는 어노테이션을 사용하여 SQL Query를 작성할 수 있지만 복잡한 Query의 작성이 불가능하기 때문에 xml로 따로 작성하였습니다. Mapper 클래스와 같은 패키지 경로의 xml은 항상 같은 패키지 경로에 존재해야 하며 Mapper 클래스가 생성되면 xml도 항상 같은 경로에 생성되어야 합니다.
