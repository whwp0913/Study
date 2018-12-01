## Apache 와 Tomcat

#### Apache
- 정적인 데이터를 처리하는 "http 웹 서버" 이다
- 클라이언트의 GET,POST 등등의 메소드의 요청에 대해 그 결과를 돌려주는 기능을 한다
- 정적인 HTML 이나 이미지를 제공하는 서버이다

#### Tomcat
- 동적인 데이터를 처리하는 "웹 서버" 이며 Web Application Server 라고도 한다
- JSP / Servlet 컨테이너 중의 하나로서 JSP 요청을 받으면 Servlet으로 변환하여 이를 실행한다
- "웹 서버" + "컨테이너" 의 결합으로 다양한 기능을 이용하여 역할을 수행할 수 있는 서버이다

#### Apache 와 Tomcat을 연동하는 이유는 무엇일까?
톰캣 자체에는 "웹 서버"의 기능이 내장되어 있기 때문에 톰캣만 사용하여 JSP가 실행되는 웹 서버를 구성할 수 있다. 하지만 톰캣의 "웹 서버" 기능은 아주 기본적인 기능만 있기 때문에 "아파치"와 연동하여 아파치가 가지고 있는 다양한 웹 서버 기능을 이용하기 위함이다. 또한, 톰캣을 설치하는 이유는 아파치는 JSP를 처리하지 못하기 때문에 JSP를 받아서 톰캣에서 처리하고 다시 아파치로 넘겨주는 작업을 한다

- 아파치 기본포트 80 & 톰캣 기본포트 8080
- 아파치와 톰캣을 연동했을 경우는 기본적으로 80 포트로 요청을 받아들인다
- 클라이언트가 요청한 정보가 정적일 경우 아파치가 직접 처리후 응답을 보내게 된다
- 클라이언트가 요청한 정보가 동적일 경우 아파치는 요청을 톰캣에 넘기고 톰캣이 처리 후 정적인 페이지를 아파치에 전달하고 아파치는 80포트를 통해 클라이언트에게 보낸다


## apache-tomcat 연동방법
"아파치" 와 "톰캣" 을 연동하는 방법은 세 가지가 있다

1. tomcat connector(mod_jk)를 사용하는 방법
2. mod_proxy를 사용하여 reverse proxy 기능을 사용하는 방법
3. mod_proxy_ajp를 사용하여 ajp protocol을 reverse proxy로 사용하는 방법

|연결방식|장점|단점|
|:---:|:---|:---|
|mod_jk|1.mod_jk를 주로 많이 사용하여 자료가 많다<br>2.JkMount 옵션을 통해 컨텐츠 별로 유연한 설정이 가능|1.별도의 모듈을 설치해야 함<br>2.설정이 어려움<br>3.톰캣전용|
|mod_proxy|1.별도 모듈 설치없음(아파치가 기본), 설정이 간편<br>2.특정 WAS에 의존 하지않음|1.url별 유연한 설정이 어려움(ProxyPassMatch필요)|
|mod_proxy_ajp|1.별도 모듈 설치없음(아파치가 기본), 설정이 간편<br>2.특정 WAS에 의존 하지않음|1.url별 유연한 설정이 어려움(ProxyPassMatch필요)


#### 1. tomcat connector - mod_jk
mod_jk 모듈은 AJP 프로토콜( Apache Jserv Protocol)을 사용하여 아파치와 톰캣을 연동하는 플러그인이다. 아파치 AJP에서 톰캣에 접근하는 포트는 8009다. 때문에 톰캣의 AJP 프로토콜 포트를 8009로 설정 해주어야 함
사전에 gcc httpd-devel 패키지가 설치되어 있어야 함 (compile 하려면)

1. tomcat-connectors 다운 -> 압축해제
2. 압축 푼 폴더 /native 하위에 ./configure --with-apxs=/usr/sbin/apxs
3. make && make install -> /etc/httpd/modules/mod_jk.so 에 복사
4. apache httpd 설정 -> httpd.conf && mod_jk.conf && workers_jk.properties
5. apache conf -> workers.properties 작성
    - 톰캣의 설정정보를 기입 (포트번호, 타입, 서버 밸런스 비율)
6. apache -> httpd.conf 작성
    - jk_moudle 로드
    - workers.properties 설정
    - Jkmount 옵션을 통해 url에 따라 workers에 작성한 톰캣으로 보낼지 설정

#### 2. mod_proxy
reverse proxy로 동작하는 모듈

#### 3. mod_proxy_ajp
AJP13 protocol을 사용하여 reverse proxy로 동작하는 방식  

## 번외. forward proxy && reverse proxy 차이
"아파치"는 mod_proxy 라는 프록시 기능을 하는 모듈이 내장되어 있음  
forward proxy 와 reverse proxy 두 가지 기능이 있다

- mod_proxy
    + forward proxy
    + reverse proxy

#### forward proxy 
클라이언트가 요청하면 forward proxy가 요청을 받아 서버에 연결하여 결과를 전달 해줌  
forward proxy는 캐슁기능이 있어 성능향상 기대

#### reverse proxy
클라이언트는 요청하면 웹 서버의 주소가 아닌 미리 설정된 reverse proxy로 요청이 가게되고 proxy 서버가 받아서 뒷단의 웹 서버에게 다시 요청을 하는 방식으로 클라이언트는 진짜 웹 서버의 정보를 알 수 없음

