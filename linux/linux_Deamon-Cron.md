## linux Deamon && Cron
Deamon은 운영체제에서 '항상 실행되는' && '항상 켜져 있는' 프로세스

1. Deamon
```bash
$ cd /etc/inid.d ( Deamon 프로그램들이 위치한 디렉토리 )
$ service 프로그램 start ( Deamon 프로그램 구동 )
$ service 프로그램 stop  ( Deamon 프로그램 정지 )
```

2. Cron
cron은 운영체제 스케줄러로써 시간이나 날짜등을 지정해 주기적으로 특정 명령들을 수행시킬 수 있음
```bash
$ crontab -e ( 스케줄러 edit, 자세한 명령어 사용법은 man crontab )
```

** .bashrc는 shell에 접속했을 때 실행되는 명령이나 프로그램을 정의할 수있음