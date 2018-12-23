## 리눅스 LVM - Logical Volume Manager

- 구성
    - 물리적 볼륨 (PV: Physical Volume): 물리적인 하드를 지칭
    - 물리적 확장 (PE: Physical Extent): PV에서 나누어서 사용하는 블록 단위 영역
    - 볼륨 그룹 (VG: Volume Group): 물리적 볼륨의 집합이자 PE의 집합
    - 논리적 그룹 (LV: Logical Volume): VG에서 필요한만큼 할당해서 만드는 논리적 단위

## 사용 중인 디스크 용량 확인

1. 시스템 디스크 용량 확인 및 LVM 설정 내용 확인
```
# df -k

Filesystem                Size  Used Avail Use% Mounted on
/dev/mapper/vg_whwp-root  8.7G  2.9G  5.4G  35% /
devtmpfs                  485M     0  485M   0% /dev
tmpfs                     496M  235M  261M  48% /dev/shm
tmpfs                     496M  6.8M  490M   2% /run
tmpfs                     496M     0  496M   0% /sys/fs/cgroup
/dev/sda1                 477M   99M  349M  22% /boot
/dev/mapper/vg_whwp-data   11G  2.2G  7.6G  23% /data
/dev/mapper/vg_whwp-apps   26G  4.1G   20G  17% /apps
tmpfs                     100M     0  100M   0% /run/user/1001
tmpfs                     100M     0  100M   0% /run/user/0
```

2. fdisk를 통해 PV 용량 확인
```
# fdisk /dev/sda

Welcome to fdisk (util-linux 2.23.2).

Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.


Command (m for help): p

Disk /dev/sda: 53.7 GB, 53687091200 bytes, 104857600 sectors
Units = sectors of 1 * 512 = 512 bytes
Sector size (logical/physical): 512 bytes / 512 bytes
I/O size (minimum/optimal): 512 bytes / 512 bytes
Disk label type: dos
Disk identifier: 0x000c4f00

   Device Boot      Start         End      Blocks   Id  System
/dev/sda1   *        2048     1026047      512000   83  Linux
/dev/sda2         1026048    41943039    20458496   8e  Linux LVM
/dev/sda3        41943040   104857599    31457280   8e  Linux LVM
```

3. 사용 중인 PV 확인
```
# pvscan

  PV /dev/sda2   VG vg_whwp         lvm2 [<19.51 GiB / 0    free]
  PV /dev/sda3   VG vg_whwp         lvm2 [<30.00 GiB / 2.65 GiB free]
  Total: 2 [49.50 GiB] / in use: 2 [49.50 GiB] / in no VG: 0 [0   ]

# pvdisplay

  --- Physical volume ---
  PV Name               /dev/sda2
  VG Name               vg_whwp
  PV Size               19.51 GiB / not usable 3.00 MiB
  Allocatable           yes (but full)
  PE Size               4.00 MiB
  Total PE              4994
  Free PE               0
  Allocated PE          4994
  PV UUID               I3axEb-Be0U-PdbJ-MYqG-e9Mq-KdXf-2eo5Z3

  --- Physical volume ---
  PV Name               /dev/sda3
  VG Name               vg_whwp
  PV Size               30.00 GiB / not usable 4.00 MiB
  Allocatable           yes
  PE Size               4.00 MiB
  Total PE              7679
  Free PE               679
  Allocated PE          7000
  PV UUID               mzw79b-KMfi-qwtO-FNLM-y0dg-Fcdl-XObNe7
```

4. 사용 중인 LV 확인
```
# lvdisplay

  --- Logical volume ---
  LV Path                /dev/vg_whwp/root
  LV Name                root
  VG Name                vg_whwp
  LV UUID                8oHoZG-2jEa-S7NU-8pmA-VpLt-46GU-lIQBOE
  LV Write Access        read/write
  LV Creation host, time localhost, 2018-12-16 00:29:03 +0900
  LV Status              available
  # open                 1
  LV Size                8.91 GiB
  Current LE             2281
  Segments               3
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     8192
  Block device           253:0

  --- Logical volume ---
  LV Path                /dev/vg_whwp/apps
  LV Name                apps
  VG Name                vg_whwp
  LV UUID                ZBXIxj-XjTi-gtvj-AKS4-Mvio-WBMQ-h4LPdE
  LV Write Access        read/write
  LV Creation host, time localhost, 2018-12-16 00:29:04 +0900
  LV Status              available
  # open                 1
  LV Size                25.62 GiB
  Current LE             6560
  Segments               2
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     8192
  Block device           253:2

  --- Logical volume ---
  LV Path                /dev/vg_whwp/swap
  LV Name                swap
  VG Name                vg_whwp
  LV UUID                9eKfKk-7TOD-fXr7-EYn9-LAxV-5W6R-a0vqGs
  LV Write Access        read/write
  LV Creation host, time localhost, 2018-12-16 00:29:04 +0900
  LV Status              available
  # open                 2
  LV Size                2.00 GiB
  Current LE             512
  Segments               1
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     8192
  Block device           253:1

  --- Logical volume ---
  LV Path                /dev/vg_whwp/data
  LV Name                data
  VG Name                vg_whwp
  LV UUID                wQ3Cpa-5vcR-VNZo-BVUx-PzLQ-3Qdp-a9Scqh
  LV Write Access        read/write
  LV Creation host, time localhost, 2018-12-16 00:29:05 +0900
  LV Status              available
  # open                 1
  LV Size                <10.32 GiB
  Current LE             2641
  Segments               2
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     8192
  Block device           253:3
```

5. 사용 중인 VG 확인
```
# vgdisplay

  --- Volume group ---
  VG Name               vg_whwp
  System ID
  Format                lvm2
  Metadata Areas        2
  Metadata Sequence No  10
  VG Access             read/write
  VG Status             resizable
  MAX LV                0
  Cur LV                4
  Open LV               4
  Max PV                0
  Cur PV                2
  Act PV                2
  VG Size               49.50 GiB
  PE Size               4.00 MiB
  Total PE              12673
  Alloc PE / Size       11994 / 46.85 GiB
  Free  PE / Size       679 / 2.65 GiB
  VG UUID               35d99P-Qwop-mKNS-xBWn-ZxMk-Ayhd-k6GNJN
```

## 추가적인 디스크를 할당하여 실제 용량 확장하기

1. 파티션 생성
```
# fdisk /dev/sda

Welcome to fdisk (util-linux 2.23.2).

Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.


Command (m for help): n
Command action
    e   extended
    p   primary partition (1-4)
p
Partition number (1-4): 3
First cylinder (할당된 용량, default 할당된 용량): [enter]
Using default value 할당된 용량
Last cylinder, +cylinders or +size{K,M,G} (할당된 용량, default 할당된 용량): [enter]
Using default value 할당된 용량

Command (m for help): t
Partition number(1-4): 3
Hex code (type L to list codes): 8e
Changed system type of partition 3 to 8e (Linux LVM)

Command (m for help): w
The partition table has been altered!

WARNING: Re-reading the partition table failed with error 16: Device or resource busy.
The kernel still uses the old table. The new table will be used at
the next reboot or after you run partprobe(8) or kpartx(8)
Syncing disks.

# shutdown -r now (리부팅)
```

2. PV 생성 - pvcreate
```
# pvcreate /dev/sda3
# pvdisplay (확인)
```

3. VG 확장 - vgextend
```
# vgextend vg_whwp /dev/sda3
# vgdisplay (확인)

  --- Volume group ---
  VG Name               vg_whwp
  System ID
  Format                lvm2
  Metadata Areas        2
  Metadata Sequence No  10
  VG Access             read/write
  VG Status             resizable
  MAX LV                0
  Cur LV                4
  Open LV               4
  Max PV                0
  Cur PV                2
  Act PV                2
  VG Size               49.50 GiB
  PE Size               4.00 MiB
  Total PE              12673
  Alloc PE / Size       11994 / 46.85 GiB
  Free  PE / Size       679 / 2.65 GiB
  VG UUID               35d99P-Qwop-mKNS-xBWn-ZxMk-Ayhd-k6GNJN

  *Free PE / Size 증가된 걸 확인
```

4. 물리적인 파티션 용량 증가
```
lvextend LV_NAME -l +PE크기

# lvextend /dev/vg_whwp/root -l +100
# lvextend /dev/vg_whwp/apps -l +100
# lvextend /dev/vg_whwp/data -l +100 
```

5. 파일시스템 반영
```
# resize2fs /dev/vg_whwp/root
# resize2fs /dev/vg_whwp/apps
# resize2fs /dev/vg_whwp/data
# df -k (확인)
```













