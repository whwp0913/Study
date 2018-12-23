## linux_Structure
```
/root
├── bin/            :user binaries, 실행 가능한 프로그램 위치 / 사용자들이 사용하는 '명령어' 위치
├── sbin/           :system binaries, 시스템을 관리하는 프로그램 위치
├── etc/            :configuration files, 프로그램들의 '설정파일' 위치
├── dev/            :device files
├── proc/           :process information
├── var/            :variable information, 내용 / 용량 증가 또는 바뀔 수 있는 파일들
├── tmp/            :temporary files, 임시 파일들이 저장되는 위치
├── home/           :home directory, 사용자들의 디렉토리 '~' 위치
├── boot/           :boot loader files
├── lib/            :system libraries, bin / sbin 프로그램들이 공통적으로 사용하는 파일들
├── opt/            :optional add-on applications
├── mnt/            :mount directory
└── usr/            :user programs, 사용자들이 설치하는 프로그램들이 위치
    ├── bin/
    ├── sbin/
    ├── lib/
    └── local/
```