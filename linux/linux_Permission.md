## linux Permission
file && directory 대해 권한을 지정하는 일 -> 주로 읽기 && 쓰기 && 실행

```bash
$ d[type] rwx[owner] ---[group] ---[other] @  3 whwp0913[owner] staff[group] 96 12 22 17:24 Applications
```

- rwx
    - r: read
    - w: write
    - x: excute
- chmod ( change mod )
    - file && directory 권한을 변경할 수 있음
    - chmod [옵션][모드][파일]
        - [옵션]
            - R 하위 파일, 디렉토리 모든 권한을 변경
            - v 실행되고 있는 모든 파일을 나열
            - c 권한이 변경된 파일내용을 출력
        - [모드]
            - 문자열 모드
                - a: all
                - u: user
                - g: group
                - o: other  
            - 8진법 모드
                - r: 4
                - w: 2
                - x: 1

