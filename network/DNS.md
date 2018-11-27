# DNS - domain name system
- hosts 파일을 이용하면 DNS server를 이용하지 않고도 아이피와 도메인명을 등록하여 웹 브라우저를 통해 접속가능하다 (ip 주소부)
- hosts wiki 참고 (변조되지 않도록 해야함. 악의적으로 조작당할 수 있음.)

## 도대체 무엇인가?
- ip로 접속하는게 아니라 이름으로 접속하게 하고싶다
- DNS server 에게 자신의 ip와 도메인명 신청을 한다
- 클라이언트는 인터넷 연결 순간에 DNS server에 자동으로 연결된다
- 1순위는 hosts 2순위는 DNS server

## public DNS
- DNS server도 ip주소를 가지고 있어야 한다
- 클라이언트는 DNS server를 어떻게 알 수 있을까? 
- 인터넷 연결한 순간에 통신사(ISP)들이 자동으로 셋팅해준다
- 8.8.8.8 은 google의 DNS server 이다

## DNS Internal
- 서버의 요청에 대한 등록
- 클라이언트의 요청에 대한 응답
- DNS server는 수만대 수천대가 존재한다
- blog.example.com. [sub domain].[second level].[top level].[root]
- 각각의 DNS server가 존재한다
- [root] DNS server는 [top level] 담당하는 DNS server 목록을 알고 있고 ... 상위가 하위를 알고 있다
- 클라이언트는 최소한 [root] DNS server의 주소를 알고있어야 한다
- 최종적으로 [sub] DNS server 까지 타고 간다

## DNS register
- Registar >>> Registry [Top-level domain] >>> ICANN [Root name server]
    1. Registar 에게 ip와 신청한 도메인의 name server를 알려준다
    2. Registar 는 Registry에게 도메인의 name server를 알려주고 Top-level domain에 등록
    3. 클라이언트는 도메인 담당 DS 도메인명과 ip주소를 등록한다

## nslookup domian
- 해당 도메인의 ip주소를 알 수 있다



