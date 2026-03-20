# Authentication System

He thong authentication duoc xay dung bang Java Spring Boot theo mo hinh MVC pho bien:

- `Controller`: nhan request va dieu huong giao dien
- `Service`: xu ly business logic dang ky tai khoan
- `Repository`: thao tac du lieu voi Spring Data JPA
- `View`: Thymeleaf templates cho login/register/dashboard
- `Security`: Spring Security bao ve route va xu ly dang nhap/dang xuat

## Cong nghe

- Java 17
- Maven 3.9+
- Spring Boot 3
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- H2 Database

## Cau truc thu muc

```text
src/main/java/com/example/authsystem
|-- config
|-- controller
|-- dto
|-- model
|-- repository
`-- service
```

## Dieu kien can

1. Cai dat Java 17 tro len.
2. Co the chay bang Maven global hoac Maven Wrapper da duoc them san trong project.

## Build project tu pom.xml

### Cach 1: Build bang Maven Wrapper

```bash
./mvnw clean package
```

Tren Windows, co the dung:

```bash
mvnw.cmd clean package
```

### Cach 2: Build bang Maven global

```bash
mvn clean package
```

Sau khi build thanh cong, file jar se nam tai thu muc:

```text
target/authentication-system-0.0.1-SNAPSHOT.jar
```

## Run project

### Cach 1: Chay bang Maven Wrapper

```bash
./mvnw spring-boot:run
```

Tren Windows, co the dung:

```bash
mvnw.cmd spring-boot:run
```

### Cach 2: Chay bang Maven global

```bash
mvn spring-boot:run
```

### Cach 3: Chay file jar sau khi build

```bash
java -jar target/authentication-system-0.0.1-SNAPSHOT.jar
```

Mac dinh ung dung chay tai:

- `http://localhost:8080/register`
- `http://localhost:8080/login`
- `http://localhost:8080/h2-console`

## Luong su dung

1. Dang ky tai khoan moi.
2. Dang nhap bang email va mat khau vua tao.
3. Sau khi dang nhap thanh cong, he thong chuyen toi `dashboard`.

## Luu y

- Database dang dung la H2 in-memory, du lieu se mat sau khi dung ung dung.
- Maven Wrapper (`mvnw`, `mvnw.cmd`) da co san trong repo, nen ban co the chay project ma khong can tu cai Maven tren may.
