<style>
#toc {
  border: 1px solid #ccc;
  display: inline-block;
  padding: 12px 20px 18px 18px;
}
</style>

# Apache && Tomcat
<div id="toc">
### 목차
- [1](#1). apache
- [2](#2). tomcat
- [3](#3). apache && tomcat 연동 이유
    - [3-1](#3-1). 서버 이중화
- [4](#4). apache && tomcat 연동 원리와 흐름
- [5](#5). apache && tomcat 연동 방법
    - [5-1](#5-1). tomcat connector - mod_jk
    - [5-2](#5-2). mod_proxy
    - [5-3](#5-3). mod_proxy_ajp
- [참고](#참고). forward proxy && reverse proxy
</div>


## [1](#toc). apache <a id="1"/>
- 정적인 데이터를 처리하는 Web Server
- HTTP protocol을 통해 통신하며 클라이언트의 GET, POST 등등 메소드의 요청에 대해 그 결과를 돌려주는 기능
- 단순HTML, 이미지를 제공하는 서버


## [2](#toc). tomcat <a id="2"/>
- 동적인 데이터를 처리하는 Web Application Server
- JSP, Servlet 컨테이너 중의 하나로서 JSP 요청을 받으면 Servlet으로 변환하여 이를 실행
- Web Server + Container 결합으로 다양한 기능을 이용하여 역할을 수행할 수 있는 서버
- DB와 연동되어 데이터를 조작, 동적인 요청처리가 가능


## [3](#toc). apache && tomcat 연동 이유 <a id="3"/>
1. tomcat은 본연의 임무인 **서블릿 컨테이너** 의 역할 / apache는 **웹서버** 의 역할을 하도록 각각의 기능을 분리하기 위해 연동
2. apache에서 제공하는 편리한 기능을 사용하기 위해 연동
3. **서버 이중화** ~ 대규모 사용자가 사용하는 시스템을 구축할 때 연동을 통해 부하 분산의 효과
    - Load Balancing
    - FailOver
4. apache 내에서만 설정할 수 있는 부분과 apache에서 제공하는 모듈을 사용하기 위해
5. 보안상의 이유 ~ 1024이하의 포트를 사용하려면 root사용자 이여야 가능하다. 그러므로 tomcat만을 사용한다면 root 사용자로 구동해야하며 이는 보안상 많은 문제를 야기할 수 있음 -> apache는 root로 구동해도 자식 process를 fork한 후 apache 그룹과 계정으로 전환한다

### [3-1](#toc). 서버 이중화 <a id="3-1"/>
1. Load Balancing  
서버에 부하가 많을 때 여러 대의 Server에게 균등하게 Traffic을 분산시켜주는 역할을 하는 서비스
    - 서버에 부하가 많을 때 처리 방법
        - Scale-up ~ Server가 더 빠르게 동작하기 위해 하드웨어 성능을 올리는 방법
        - Scale-out ~ 하나의 Server 보다 여러 대의 Server가 나눠서 일을하는 방법
    - **따라서 Load Balancing의 경우 Scale-out의 한 방법이라고 볼 수 있다**

2. FailOver  
평소 사용하는 서버의 클론을 가지고 있다가 사용 서버가 장애로 인해 사용이 어렵게 됐을경우 클론서버로 그 일을 대신 처리하게 해서 **무정지 시스템**을 구축해주는 것

## [4](#toc). apache && tomcat 연동 원리와 흐름 <a id="4"/>
1. 연동 원리
    - apache와 tomcat이 연동하기 위해선 **AJP** 를 통해 서로 통신을 해야한다
    - **AJP** 란 apache와 같은 웹 서버와 톰캣과 같은 외부 서비스를 연동하기 위해 정한 프로토콜이다
2. 흐름
    - apache의 httpd.conf에 Tomcat연동을 위한 설정과 톰캣에서 처리할 요청을 지정
    - Client는 apache에(port:80) 접속을 요청
    - apache는 요청이 tomcat에서 처리할 요청인지 확인 후 처리해야한다면  tomcat의 AJP포트(default:8009)에 접속해 요청을 전달
    - tomcat은 apache로 부터 요청을 전달받아 처리한 후 결과를 apache에게 돌려준다
    - apache는 tomcat으로부터 받은 처리 결과를 Client에게 전송


## [5](#toc). apache && tomcat 연동 방법 <a id="5"/>
***apache 와 tomcat 을 연동하는 3가지 방법***

|연결방식|장점|단점|
|:---:|:---|:---|
|mod_jk|1.mod_jk를 주로 많이 사용하여 자료가 많음<br>2.JkMount 옵션을 통해 컨텐츠 별로 유연한 설정이 가능|1.별도 module 설치<br>2.설정의 어려움<br>3.tomcat전용|
|mod_proxy|1.별도 module 설치x(apache 기본), 설정 간편<br>2.특정 WAS에 의존x|1.url별 유연한 설정의 어려움(ProxyPassMatch필요)|
|mod_proxy_ajp|1.별도 module 설치x(아파치가 기본), 설정 간편<br>2.특정 WAS에 의존x|1.url별 유연한 설정의 어려움(ProxyPassMatch필요)

#### [5-1](#toc). tomcat connector - mod_jk <a id="5-1"/>
***mod_jk 모듈을 이용하는 방법***  
mod_jk는 AJP(Apache Jserv Protocol)를 사용하여 apache와 tomcat을 연동하는 플러그인이다.

1. apache AJP에서 tomcat에 접근하는 포트는 8009다. 때문에 tomcat의 AJP 포트를 8009로 설정 해주어야 함  
2. 또한, 사전에 gcc httpd-devel 패키지가 설치되어 있어야 함 (compile 하기위해)

#### [5-2](#toc). mod_proxy <a id="5-2"/>
***forward proxy 와 reverse proxy로 동작하는 모듈***

1. 간단한 흐름
    - Client --> Request --> apache port 80(mod_proxy) --> tomcat port 8080
2. vhost.conf 설정
```shell
# vi /etc/httpd/conf.d/vhost.conf 
<VirtualHost *:80>
    ServerName 192.168.0.7
 
    ProxyRequests Off
    ProxyPreserveHost On
 
    ProxyPass / http://127.0.0.1:8080/
    ProxyPassReverse / http://127.0.0.1:8080/
</VirtualHost>

ProxyRequests : 포워드 프록시로 사용할 경우 On, 리버스 프록시 사용은 Off
ProxyPreserveHost : 브라우저가 보낸 Host: HTTP 헤더를 프록시 요청
```


#### [5-3](#toc). mod_proxy_ajp <a id="5-3"/>
***mod_proxy 방법과 비슷하지만 AJP를 사용하여 reverse proxy로 동작하는 방식***

1. protocol을 ajp로 바꿔주면 된다
2. vhost.conf 설정
```shell
# vi /etc/httpd/conf.d/vhost.conf
<VirtualHost *:80>
    ServerName 192.168.0.7
 
    ProxyRequests Off
    ProxyPreserveHost On
 
    ProxyPass / ajp://127.0.0.1:8009/
    ProxyPassReverse / ajp://127.0.0.1:8009/
</VirtualHost>
```

## [참고](#toc). forward proxy && reverse proxy <a id="참고"/>
Apache는 mod_proxy 라는 프록시 기능을 하는 모듈이 내장되어 있다. forward proxy 와 reverse proxy 두 가지 기능이 있다

1. forward proxy 
    - 클라이언트가 요청하면 forward proxy가 요청을 받아 서버에 연결하여 결과를 전달
    - forward proxy는 캐싱기능이 있어 성능향상 기대

2. reverse proxy
    - 클라이언트는 요청하면 웹 서버의 주소가 아닌 미리 설정된 reverse proxy로 요청이 간다 
    - proxy 서버가 받아서 뒷단의 웹 서버에게 다시 요청을 하는 방식으로 클라이언트는 진짜 웹 서버의 정보를 알 수 없음


