#### 목차 <a id="toc"></a>
- [1](#1). 컴퓨터 네트워크
    - [1-1](#1-1). 프로토콜 - protocol
    - [1-2](#1-2). TCP/IP 탄생배경
- [2](#2). TCP/IP 개요
    - [2-1](#2-1). 통신 프로토콜
    - [2-2](#2-2). TCP/IP 란
    - [2-3](#2-3). 계층화
    - [2-4](#2-4). TCP/IP 구조
    - [2-5](#2-5). 계층 간 통신방법
- [3](#3). 통신 서비스와 프로토콜
    - [3-1](#3-1). URL
    - [3-2](#3-2). WWW
    - [3-3](#3-3). 전자메일
    - [3-4](#3-4). 파일전송
    - [3-5](#3-5). 원격 로그인
- [4](#4). Application
    - [4-1](#4-1). Application Header
    - [4-2](#4-2). HTTP PROTOCOL
        - [4-2-1](#4-2-1). 통신 유지 장치 - 쿠키

## [1](#toc). 컴퓨터 네트워크 - computer network <a id="1"></a>
정보나 노동력 등 다양한 종류의 자산을 주고받을 수 있는 상태

- LAN (Local Area NetWork)
    + 좁은 공간에 있는 기기끼리 연결한 네트워크 > LAN 케이블 이용
- WAN (Wide Area NetWork)
    + 지리적으로 떨어진 장소에 있는 기기끼리 연결한 대규모의 네트워크 > 광섬유 케이블, 공중망 이용
- INTERNET
    + 여러 개의 LAN, WAN을 연결한 전 세계 규모의 네트워크

### [1-1](#toc). 프로토콜 - protocol <a id="1-1"></a>
컴퓨터끼리 문제없이 교류할 수 있도록 정해진 **절차** > 즉, **TCP/IP**는 통신절차 라고 생각하면 된다

### [1-2](#toc). TCP/IP 탄생배경 <a id="1-2"></a>
1. 1960년대 **미국 국방성**이 개발을 지원한 ***ARPANET*** 이라는 네트워크 상에서 사용할 프로토콜로 개발  
2. ***데이터 >> 신호로 변환 >> 전달 >> 데이터로 변환*** 이라는 일련의 흐름을 통일시킨 절차를 기본으로 하여 수행되는 TCP/IP 구조가 생성  
3. TCP/IP의 공통된 구조로 전 세계 네트워크를 연결한 것이 **INTERNET**이다 


## [2](#toc). TCP/IP 개요 <a id="2"></a>
- TCP/IP 에서는 ***데이터를 신호로, 신호를 데이터로*** >> **5 LAYER** 절차를 거친다
- TCP/IP 특징 중 하나는 ***데이터를 일정한 크기로 분할해서 보낸다***

***5 LAYER***

1. Network Access (물리 + 데이터링크 계층)
2. Internet (네트워크 계층)
3. Transport (전송 계층)
4. Application (응용 계층)

### [2-1](#toc). 통신 프로토콜 <a id="2-1"></a>
기본적으로 데이터를 주고받기 위해선 **송신측**과 **수신측**의 컴퓨터가 미리 정해 놓은 공통된 매뉴얼에 따라 연락을 취해야 한다

### [2-2](#toc). TCP/IP 란 <a id="2-2"></a>
TCP/IP는 전 세계적으로 **공통된 통신 프로토콜**이다

### [2-3](#toc). 계층화 <a id="2-3"></a>
TCP/IP에서는 **데이터 송수신**과 관련된 일련의 작업을 몇 개의 단계로 나눠서 수행

### [2-4](#toc). TCP/IP 구조 <a id="2-4"></a>
- Application : 애플리케이션에 맞춰 통신을 수행할 수 있도록 한다 (HTTP, FTP, SMTP ...)
- Transport : 송신되는 데이터를 수신측 애플리케이션에 전달하기 위해 작동
- Internet : 수신측 컴퓨터까지 데이터를 전달하기 위해 작동
- Network Access : 네트워크에 연결된 기기 간을 전송할 수 있도록 하고(Ethernet, FDDI, ATM...)  
데이터를 신호로, 신호를 데이터로 변환한다

### [2-5](#toc). 계층간 연락 방법 <a id="2-5"></a>
송신측의 각 **계층**에서는 수신측의 동일한 **계층**에서 필요한 정보를 공통된 서식으로 추가한다

- 각 계층에서 데이터의 앞과 뒤에 <u>헤더</u> 또는 <u>트레일러</u>를 추가한다
- 각 계층에서 추가된 헤더와 트레일러는 동일한 계층에서만 사용된다
```
[헤더][데이터][트레일러] -> [헤더][헤더:데이터:트레일러][트레일러] ....
```


## [3](#toc). 통신 서비스와 프로토콜 <a id="3"></a>
통신 서비스는 <u>컴퓨터끼리 주고받기에 의해 이뤄진다</u>라기보다는 좀더 엄밀히 말하자면 '컴퓨터끼리'가 아닌 <u>컴퓨터 속 프로그램끼리의 주고받기</u>라고 할 수 있다

- 서비스를 제공하는 기능을 가진 프로그램을 *서버*
- 서비스를 받는 프로그램을 *클라이언트*

### [3-1](#toc). URL <a id="3-1"></a>
- URL은 Uniform Resource Locator의 약자이다
- URL 구조는 다음과 같다
```
http : //www.example.co.kr :   80    /book/comic/ title.html
[스킴]  [      도메인       ]   [포 트] [   경 로    ] [  파일명  ]
```
- 스킴은 서비스의 종류를 나타낸다

    스킴|종류
    :---:|:---:
    http|www
    ftp|파일전송
    mailto|전자메일
    telnet|원격 로그인

### [3-2](#toc). WWW <a id="3-2"></a>
World Wide Web으로서 <u>웹 페이지에 다른 페이지의 위치 정보</u>를 심어 놓음으로써 양쪽을 연결할 수 있는 <u>하이퍼텍스트(hypertext)</u>라는 문서로 작성된다

- WWW는 서버와 브라우저의 <u>주고받기</u>이다
- HTTP를 기초로 일어난다

### [3-3](#toc). 전자메일 <a id="3-3"></a>
사용자끼리 문자나 파일을 주고받을 수 있는 서비스로 <u>전자메일 서비스</u>라고 한다

- 전자메일은 <u>메일 서버</u>와 <u>메일러</u>의 주고받기로 이루어진다
- 메일 전송은 SMTP 서버
- 클라이언트에게 메일 제공을 담당하는 POP 서버

### [3-4](#toc). 파일전송 <a id="3-4"></a>
컴퓨터 간 <u>파일을 간단히 주고받을 수 있는 서비스</u>

- 파일전송은 FTP 서버를 이용
- FTP 서비스에서 클라이언트는 <u>전용 어플리케이션</u> 또는 <u>웹 브라우저</u>가 된다

### [3-5](#toc). 원격 로그인 <a id="3-5"></a>
떨어진 장소의 <u>다른 컴퓨터를 조작할 수 있는 서비스</u>

- 대표적으로 Telnet 서비스가 있다
- TELNET 프로토콜을 이용
- 보안 기능을 가지고 있는 SSH(Secure Shell)도 있다


## [4](#toc). Application <a id="4"></a>
TCP/IP 계층 중 가장 위에 위치한 것이 **애플리케이션층**이다. 컴퓨터끼리 주고받기를 **사용자**가 이용할 수 있는 **통신 서비스**라는 형태로 만드는 것이 이 계층의 역할이다

- '송신측과 수신측'이 아닌 '클라이언트와 서버' 라는 개념
- 전자메일 WWW 등 서비스의 수만큼 애플리케이션 프로토콜이 존재

### [4-1](#toc). Application Header <a id="4-1"></a>
애플리케이션층에서 추가되는 헤더를 **애플리케이션 헤더**라고 한다. 여기에는 '요청과 응답'에 관한 정보가 들어 있다

- application header의 언어
    + 텍스트 기반 --> 사람이 읽을 수 있는 언어
    + 바이너리 기반 --> 사람이 읽을 수 없지만 컴퓨터 처리는 더 빠름

### [4-2](#toc). HTTP PROTOCOL
WWW서비스를 지지하고 있는 HTTP 프로토콜이다. HTTP 프로토콜은 **하나의 요청에 하나의 응답**을 반환하는 간단한 프로토콜이며 '요청 패킷' 과 '응답 패킷'을 이용한다

- 요청 패킷
    + 메소드 --> 요청의 종류
    + 요청 헤더 --> 서버에 전달하는 클라이언트의 정보
    + 공백 줄 --> 헤더와 본문의 경계
    + 본문 --> 요청 시 필요한 데이터
- 응답 패킷
    + 상태 줄 --> 요청에 대한 처리결과
    + 응답 헤더 --> 클라이언트에게 전달할 데이터에 관한 정보
    + 공백 줄 --> 헤더와 본문의 경계
    + 본문 --> 클라이언트에게 전달한 데이터

### [4-2-1](#toc). 통신의 유지하는 장치 - 쿠키
HTTP 프로토콜은 접속 상태를 유지한 채로 주고받기를 계속할 수 없다. 따라서 쿠키를 이용하여 클라이언트의 정보를 클라이언트측에 저정해 두고 클라이언트는 서버에 요청 시 쿠키를 함께 담아 보낸다

- 쿠키
    + 쿠키는 HTTP 프로토콜의 정규 장치가 아니다
    + CGI (Common Gateway Interface) 등의 장치와 함께 사용한다
