## linux background && foreground
리눅스에서 현재 작업 중인 환경을 background 또는 foreground 상태로 전환이 가능

1. background
    - 현재 작업 중인 프로세스 background 전환 -> ctrl + z
    - background 에서 실행 중인 프로세스 확인 -> jobs
    - 다수의 프로세스를 background로 전환할 수 있음

2. foreground
    - background 에서 실행 중인 프로세스를 다시 foreground로 전환 -> fg
    - 다수의 프로세스가 backgorund에 있는 상황이라면 'jobs' 명령을 통해 프로세스 번호를 확인 후 -> fg %[프로세스 번호]  
    를 통해 foreground로 전환가능

3. process kill
    - background에 있는 프로세스를 강제종료 -> kill %[프로세스 번호] 또는 kill -9 %[프로세스 번호]