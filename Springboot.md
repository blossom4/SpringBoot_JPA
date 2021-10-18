# Springboot



### 1. 프로젝트 생성



1. 프로젝트 기본설정

- spring initializr
  - https://start.spring.io/

- Dependencies
  - Spring Web 
  - Spring Data JPA 
  - Thymeleaf (선택)
  - Lombok (선택)

설정 후 GENERATE 하면 압축파일 생성



2. Import  project

- Existing Gradle Project -> generate 한 파일 불러오기



3. setting 확인

- src/main/java 폴더에서 Application.java 파일 실행

- src/test/java 폴더에서 ApllicationTests.java 파일 실행

  localhost:8080 접속 했을 때 다음과 같이 나오면 세팅완료

  ```markdown
  Whitelabel Error Page
  This application has no explicit mapping for /error, so you are seeing this as a fallback.
  
  Thu Sep 02 15:17:40 KST 2021
  There was an unexpected error (type=Not Found, status=404).
  ```

  

4. Eclipse Lombok Setting (단순 반복작업을 덜어주는 라이브러리)

- spring initailizr에서 lombok을 받았기 때문에 Project and External Dependencies에 lombok.jar 파일이 있다.
- lombok.jar파일이 다운되어있는 경로 확인 후 찾아가서 파일 실행
- 내가 사용하는 IDE 설정하고 install / update 클릭하면 완료된다.

5. application.properties / .yml

- yml 파일을 사용하려면 Market Place에서 Yedit을 다운로드하고 확장자를 .yml로 만들면된다.
- yml을 사용하면 훨씬 간편하게 관리할 수 있다.

6. @Getters는 호출하는것 만으로는 어떠한 변화가 있는것은 아니기 때문에 lombok을 사용하여 편리하게 세팅해도 된다.  그러나 @Setters는 어떠한 변화가 생길 수 있고 코드들이 복잡해질 수록 유지보수가 힘들어진다.

7. 값 타입은 변경이 불가능하게 설계하는 것이 좋다. 

   ```java
   public class test {
       
       private Long id;
       private String name;
       
       // 기본생성자가 있어야 reflection이나 proxy같은 것을 할 수 있다.
       // 다만 public으로 생성하면 여러군데에서 호출 가능해지므로 protected로 보호한다.
       protected test() {
       }
       
       
   }
   ```

8. (fetch = FetchType.LAZY) 지연로딩으로 설정해주어야 연관된 query만 선택적으로 실행한다.

   default 설정은 EAGER 즉시실행이므로 하나를 불러오면 모든것이 다 끌고와진다 따라서 데이터 양이 방대할 경우 문제가 생길 수 있다.



## 겪었던 오류 모음



org.h2.jdbc.JdbcSQLNonTransientException: 연결된 db의 경로나 이름이 잘못되었다.

JUnit으로 test할 때 함수에 thrwos IOException 이 아니라 Exception해야한다.

JUnit 버전마다 SpringBoot라는것을 지정해주는 태그가 조금씩다르다.

JUnit 4 = @RunWith(SpringRunner.class)

@Test 를 사용하기 위한 import가 import org.junit.jupiter.api.Test; 이어야한다.

어떤 것을 import할 때 @~~~~(여기 내부에서 부르면 error가 생긴다.) 따라서 외부에서 미리 improt를 하고 안에서 사용해야한다.