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
- [1](#1). Apache
- [2](#2). Tomcat
- [3](#3). Apache && Tomcat 연동 이유
    - [3-1](#3-1). 서버 이중화
- [4](#4). Apache && Tomcat 연동 원리와 흐름
- [5](#5). Apache && Tomcat 연동 방법
    - [5-1](#5-1). tomcat connector - mod_jk
    - [5-2](#5-2). mod_proxy
    - [5-3](#5-3). mod_proxy_ajp
- [번외](#번외). forward proxy && reverse proxy
</div>


## [1](#toc). Apache <a id="1"/>
- 정적인 데이터를 처리하는 "http 웹 서버" 이다
- 클라이언트의 GET,POST 등등의 메소드의 요청에 대해 그 결과를 돌려주는 기능을 한다
- 정적인 HTML 이나 이미지를 제공하는 서버이다


## [2](#toc). Tomcat <a id="2"/>
- 동적인 데이터를 처리하는 "웹 서버" 이며 Web Application Server 라고도 한다
- JSP / Servlet 컨테이너 중의 하나로서 JSP 요청을 받으면 Servlet으로 변환하여 이를 실행한다
- "웹 서버" + "컨테이너" 의 결합으로 다양한 기능을 이용하여 역할을 수행할 수 있는 서버이다


## [3](#toc). Apache && Tomcat 연동 이유 <a id="3"/>
1. Tomcat은 본연의 임무인 **서블릿 컨테이너** 의 역할 / Apache는 **웹서버** 의 역할을 하도록 각각의 기능을 분리하기 위해 연동
2. Apache에서 제공하는 편리한 기능을 사용하기 위해 연동
3. **서버 이중화** ~ 대규모 사용자가 사용하는 시스템을 구축할 때 연동을 통해 부하 분산의 효과
    - Load Balancing
    - FailOver
4. Apache 내에서만 설정할 수 있는 부분과 Apache에서 제공하는 모듈을 사용하기 위해
5. 80 포트의 사용권한

### [3-1](#toc). 서버 이중화 <a id="3-1"/>
1. Load Balancing  
서버에 부하가 많을 때 여러 대의 Server에게 균등하게 Traffic을 분산시켜주는 역할을 하는 서비스
    - 서버에 부하가 많을 때 처리 방법
        - Scale-up ~ Server가 더 빠르게 동작하기 위해 하드웨어 성능을 올리는 방법
        - Scale-out ~ 하나의 Server 보다 여러 대의 Server가 나눠서 일을하는 방법
* **따라서 Load Balancing의 경우 Scale-out의 한 방법이라고 볼 수 있다**
2. FailOver  
평소 사용하는 서버의 클론을 가지고 있다가 사용 서버가 장애로 인해 사용이 어렵게 됐을경우 클론서버로 그 일을 대신 처리하게 해서 **무정지 시스템**을 구축해주는 것

## [4](#toc). Apache && Tomcat 연동 원리와 흐름 <a id="4"/>
1. 연동 원리
    - Apache와 Tomcat이 연동하기 위해선 **AJP protocol** 을 통해 서로 통신을 해야한다
    - **AJP protocol** 이란 Apache와 같은 웹 서버와 톰캣과 같은 외부 서비스를 연동하기 위해 정한 프로토콜이다
2. 흐름
    - Apache의 httpd.conf에 Tomcat연동을 위한 설정과 톰캣에서 처리할 요청을 지정
    - Client는 Apache에(port:80) 접속을 요청
    - Apache는 요청이 Tomcat에서 처리할 요청인지 확인 후 처리해야한다면  톰캣의 AJP포트(default:8009)에 접속해 요청을 전달
    - Tomcat은 Apache로 부터 요청을 전달받아 처리한 후 결과를 Apache에게 돌려준다
    - Apache는 Tomcat으로부터 받은 처리 결과를 Client에게 전송


## [5](#toc). Apache && Tomcat 연동 방법 <a id="5"/>
"아파치" 와 "톰캣" 을 연동하는 방법은 세 가지가 있다

1. tomcat connector(mod_jk)를 사용하는 방법
2. mod_proxy를 사용하여 reverse proxy 기능을 사용하는 방법
3. mod_proxy_ajp를 사용하여 ajp protocol을 reverse proxy로 사용하는 방법

|연결방식|장점|단점|
|:---:|:---|:---|
|mod_jk|1.mod_jk를 주로 많이 사용하여 자료가 많다<br>2.JkMount 옵션을 통해 컨텐츠 별로 유연한 설정이 가능|1.별도의 모듈을 설치해야 함<br>2.설정이 어려움<br>3.톰캣전용|
|mod_proxy|1.별도 모듈 설치없음(아파치가 기본), 설정이 간편<br>2.특정 WAS에 의존 하지않음|1.url별 유연한 설정이 어려움(ProxyPassMatch필요)|
|mod_proxy_ajp|1.별도 모듈 설치없음(아파치가 기본), 설정이 간편<br>2.특정 WAS에 의존 하지않음|1.url별 유연한 설정이 어려움(ProxyPassMatch필요)


#### [5-1](#toc). tomcat connector - mod_jk <a id="5-1"/>
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

#### [5-2](#toc). mod_proxy <a id="5-2"/>
reverse proxy로 동작하는 모듈

#### [5-3](#toc). mod_proxy_ajp <a id="5-3"/>
AJP13 protocol을 사용하여 reverse proxy로 동작하는 방식  

## [참고](#toc). forward proxy && reverse proxy <a id="참고"/>
Apache는 mod_proxy 라는 프록시 기능을 하는 모듈이 내장되어 있다. forward proxy 와 reverse proxy 두 가지 기능이 있다

1. forward proxy 
    - 클라이언트가 요청하면 forward proxy가 요청을 받아 서버에 연결하여 결과를 전달
    - forward proxy는 캐싱기능이 있어 성능향상 기대

2. reverse proxy
    - 클라이언트는 요청하면 웹 서버의 주소가 아닌 미리 설정된 reverse proxy로 요청이 간다 
    - proxy 서버가 받아서 뒷단의 웹 서버에게 다시 요청을 하는 방식으로 클라이언트는 진짜 웹 서버의 정보를 알 수 없음


