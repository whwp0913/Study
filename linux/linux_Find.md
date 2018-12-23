## linux_Find

#### 파일의 위치를 찾는 방법
1. find
    - directory 를 검색
    - find [option] [path] [type] expression
2. locate
    - 컴퓨터에 저장되어 있는 파일목록이 저장된 '데이터베이스'를 검색
    - 간편하고 빠름
    - locate [filename]

#### 실행파일의 위치를 찾는 방법
1. whereis
    - 실행파일과 매뉴얼파일의 위치를 검색
    - $PATH에 정의된 경로에 따라 검색함
    - 운영체제는 $PATH에 담겨있는 변수들을 검색해서 실행시킨다, 즉 $PATH는 환경변수