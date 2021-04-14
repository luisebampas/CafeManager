#  POS/키오스크 통합형 카페 매장 시스템 프로젝트

### 4.14(수)

- 관리자앱, 사용자 앱  깃-허브 저장소 통합.


  성시영




심기훈: Cafe_User Main 마무리



=======
- 성시영
- 조재언
- 심기훈: Cafe_User Main 마무리
- 한상범 - cctv xml, activity 구성

### 4.13(화)

#### 개발 진행 현황 









### 4.12(월) 

- 관리자 어플 화면설계 회의 내용

  - 하단 네이게이션을 활용, 홈 / 재고관리 / 환경제어 / CCTV 페이지 분류

  - 홈 화면 : 좌석 및 주문 현황

    - 가장 빈번하고 필수적인 정보인만큼 홈화면에 배치. 화면을 양분하여 각각 좌석, 주문 현황 표시.

    - 좌석 현황 매장 테이블 배치를 따름. 실제 고객들의 테이블의 어떤 메뉴가 나갔는지 파악 가능.

    -   주문이 들어오면 주문내용이 하나씩 올라오는 식으로 주문현황 표시. ''주문완료'' 되면 주문내용은 삭제되고, 좌석현황의 상태를 '제조중'에서 '수령대기' 상태로 변경.

      

  - 재고관리 화면

    - 메인 페이지는 소진임박 / 유통기한 임박 재료들 표시

    - 각각의 탭으로 이동하면 특정 냉장고, 보관소의 물품들을 수량을 시각화하여 출력.

    - 남은 재료들의 수량은 소진임박 정도에 따라 빨강/ 노랑/ 초록 등 색상으로 표현. 

      

  - 환경제어 화면

    - 온/습도, 미세먼지, 가스유출 여부 등 실시간 상태 모니터링 및 제어 가능.

    - 만일, 가스가 유출되면 유관 소방서 및 안전업체에게 알림을 전달.

    - 미세먼지 상태 정보는 심각 / 주의 / 정상에 따라 표정 이모티콘의 변화로 시각화하여 전달. 

      

  - CCTV 화면
    - 실시간 녹화화면 표시. 
    - 스크린샷 저장 기능. 



### 4. 9(금)

 - 장비 신청

   

 - 관리자 화면 설계 분담

   - 좌석 현황 화면 - 테이블별 주문 완료여부, 주문 제품시각화

   - 매장 환경제어 화면 - 온도, 습도, 

   - 주문현황 화면

   - CCTV 모니터 / 제어 화면

   - 재고 조회 화면 - (냉장고별로 조회 / 매진임박 재료 조회 )

     

- 테이블 높이 제어 모터관련 논의

  1) 스텝모터 + 렉커, 기어 활용(저비용)

  2) 리니어 액츄에이터(고비용)







### 4.8(목)

- 과제 : https://www.devicemart.co.kr/goods/view?no=12989030

  ​		   액추에이터에 맞는 스텝모터 드라이브 탐색

- 진행 상황

  성시영 : 카트(장바구니) 디자인 어댑터, 프레그먼트 제작 지속 중

  심기훈 :  메인화면 리스트 / 리스너를 통한 인텐트 전달을 위한 기능 구현 중

  조재언, 한상범 : 메뉴-주문 화면 통합. 주문에서 카트로 넘기는 인덴트 구현. 좌석제어 환경 디자인 및 커스텀라이징 시작.  



1. 추후 과제

   1) 인텐트 작업 

   ​     메뉴 -> 주문 -> 결제

   ​     메뉴 -> 장바구니 -> 결제

   기훈: 메인 -> order intent

   재언: order -> 메뉴창(drawer)

   상범: 메뉴창 -> 장바구니

   시영: 장바구니 -> 결제창

   

   2) 좌석 제어 레이아웃 

   3) DB테이블 

   4) 관리자 앱 제작



남은 것: 
1) 세부 디자인  <---
2) 좌석제어 기능 (xml이랑 디자인)
3) 관리자앱(다음주?)





###  4. 7(수), Cafe_User 어플 제작 시작.

#### 	1. 기초화면 구성 및 ERD 구성 완료.

#### 	2. 각자 레이아웃 제작 시작.

#### 	3. 협업 및 형상관리를 위한 git-hub 저장소 마련.



___

# 참고자료



1. 기획발표 PPT 링크(편집 가능)

   https://o365cbnu-my.sharepoint.com/:p:/g/personal/luisebampas_cbnu_ac_kr/ERglNs4hIcRAiV4GAJMSVHMBojBcy2bf6cSvp6cavnQU1A?e=7wswAh

2. ERD 링크 https://www.erdcloud.com/d/awaHKhBdZHnxHjwvr
3. 안드로이드 오픈소스 https://kmshack.github.io/AndroidUICollection/