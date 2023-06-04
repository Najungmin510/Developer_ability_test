# 2023_hallym_developer_Test   
## 한림대학교 감사운동 애플리케이션 개발자 역량 테스트 과제

본 프로젝트는 한림대학교 - 감사운동 애플리케이션 안드로이드 유지보수 개발자로 지원한 사람들의 역량 파악을 위해 진행된 프로젝트입니다.   
기존 학교 공식 사이트 및 애플리케이션에서 문제점을 느낀 후, 이를 개선한 애플리케이션을 기획중에 있었습니다.      
그래서 현재 디자인 하고 있던 애플리케이션의 이미지대로 디자인을 재구성해보았습니다.
> 역량 테스트를 위한 1인 개발 <br> 
> 과제 수행 기간 : 2023 4/30 ~ 2023 6/4 <br> 
> ⚒️사용한 기술 스택 ⚙️ : Android studio, XD, Retrofit2<br>      
> 🖌️ 전체 UI
> ![UI](https://github.com/Najungmin510/Developer_ability_test/assets/83949732/e06a01d2-5a65-4a68-ab8e-435a326a817e)
  

현재 애플리케이션 문제점 : 로그인은 정상 작동하나, 로그인 후 메인 화면으로 넘어갈 때 앱이 다운되는 현상 지속발생<br>
=> 에러 문구도 뜨지 않아 원인 파악에 어려움을 겪고 있음 (adapter부분일거라 추측중)<br>
=> 현재 에러가 발생한 부분 & 구현하지 못한 부분은 기말고사가 끝나는 날인 19일부터 다시 작업 재개 예정<br>

# 목차   
1. 애플리케이션 설치 및 실행 방법
2. 기능 소개   
3. 사용한 라이브러리   
4. 참고 사이트      

## 1. 애플리케이션 설치 및 실행 방법<br>
<img width="69" alt="icon" src="https://github.com/Najungmin510/Developer_ability_test/assets/83949732/1b3a7908-e3fc-41aa-883d-2f40cb22f39f"><br>
zip파일로 압축되어 있는 APK파일을 핸드폰으로 다운로드 받은 후, 압축을 해제합니다.<br>
출처를 알 수 없는 앱 설치 경고창이 뜨면, **무시하고 설치를 클릭**합니다.<br>
안전하지 않은 앱 차단됨 경고창이 뜨면 **"세부정보 더 보기"를 클릭한 후 "무시하고 설치하기"를 클릭**합니다.<br><br>
다운로드 완료 후, "림대생" 애플리케이션이 추가됩니다. 해당 애플리케이션 실행 시 바로 로그인 화면으로 들어갑니다.<br>
jsonplaceHolder의 users에 포함되어 있는 사용자의 이름(Name) 입력 시 로그인이 가능하며,<br>
애플리케이션에서 제공하는 기능을 사용할 수 있습니다. (에러로 인해 현재 불가) <br><br>

## 2. 기능 소개
### 2-1. 로그인<br>
jsonplaceHolder사이트의 /users json구조에서 볼 수 있는 사용자의 이름(Name)을 입력하면 로그인이 가능합니다.<br>
이름이 아닌 userName 입력, 공백, 존재하지 않는 이름 입력 시 로그인이 불가능합니다.<br><br>
![LoginTest](https://github.com/Najungmin510/Developer_ability_test/assets/83949732/e7391474-882c-4222-bfcb-a8ab858969a3)<br><br>

**[로그인 가능한 Name 목록]** <br><br>
Leanne Graham, Ervin Howell, Clementine Bauch, Patricia Lebsack, Chelsey Dietrich, Mrs. Dennis Schulist,<br>
Kurtis Weissnat, Maxime_Nienow, Glenna Reichert, Clementina DuBuque<br><br>

### 2-2. 게시글 및 댓글 작성 (화면 접속 불가 오류)<br>
모든 사용자의 POST가 화면에 출력됩니다.<br>
게시글 추가를 원할 경우, 주황색 작성 버튼을 클릭 해 리스트에 추가할 수 있습니다.<br>
수정 & 삭제는 자신의 것만 진행 가능하며 다른 사람의 게시물은 확인만 가능합니다.<br>
댓글은 자유롭게 작성할 수 있습니다.<br>

### 2-3. 할 일 체크리스트 (화면 접속 불가 오류)<br>
로그인 한 사용자의 TODO List가 화면에 출력됩니다.<br>
주황색 작성 버튼을 클릭 해 리스트에 추가할 수 있습니다.<br>

![error](https://github.com/Najungmin510/Developer_ability_test/assets/83949732/9c524b20-0038-436c-9641-e3d7f1e70738)
## 3. 사용한 라이브러리   
> Android Studio Jetpack   
> Kotlin data class File from Json   
> Retrofit2   
> CookieJar

## 4. 참고 사이트<br>
> Retrofit & JsonplaceHolder 참고 사이트<br> 
> [[안드로이드 Retrofit 1] - 초기설정과 api @GET](https://velog.io/@leeyjwinter/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Retrofit-%EC%B4%88%EA%B8%B0%EC%84%A4%EC%A0%95%EA%B3%BC-%EC%8B%A4%ED%96%89)<br>
> [안드로이드 - Json을 Kotlin Data 클래스로](https://codingpracticing.tistory.com/223)<br>
> [jsonplaceHolder 공식사이트](https://jsonplaceholder.typicode.com/)<br>
> [[안드로이드 개인공부] Retrofit에 대해서 단계별로 공부해보자!](https://zzandoli.tistory.com/48)<br>
> [Retrofit 깃허브](http://devflow.github.io/retrofit-kr/)<br>
> [Retrofit 사용하기](https://jslee-tech.tistory.com/18)<br>
> [[Android] Retrofit 사용하여 서버와 http 통신하기 - (3) 통신결과 리싸이클러뷰에 연결하기](https://hanyeop.tistory.com/202)<br>
> [Retrofit - Send a simple POST Request | Android Studio Tutorial](https://www.youtube.com/watch?v=ok697I1j1aE&list=PLSrm9z4zp4mF1Ssdfuocy2XH5Bw4wLLNw&index=4)

> material3 error 해결 참고 사이트   
> [Error : IllegalArgumentException: The style on this component requires your app theme to be Theme.MaterialComponents](https://stackoverflow.com/questions/53476115/error-illegalargumentexception-the-style-on-this-component-requires-your-app)<br>
> [안드로이드 스튜디오에서 레이아웃 프리뷰가 보이지 않는 문제 해결법](https://enant.tistory.com/7)<br>

> 로그인 세션 유지 방법 참고 사이트<br>
> [[안드로이드/Android]Retrofit에서 Interceptor를 이용해 쿠키/세션 유지하는 방법](https://gun0912.tistory.com/50)<br>
> [Android 쿠키 동기화(retrofit2, webview)](https://easy-coding.tistory.com/54)<br>
> [okhttp 깃허브](https://github.com/square/okhttp/tree/master)<br>
> [Android Cookie Store](https://android-arsenal.com/details/1/8000)<br>

> 다이얼로그 구현 방법 참고 사이트<br>
> [[Android] 하단 다이얼로그 BottomSheetDialog 구현하기](https://win-record.tistory.com/41)<br>
> [[Anroid Dialog] 2. Compose AlertDialog를 이용해 다이얼로그 만들기](https://kotlinworld.com/236)<br>

> Multi View 구현 방법 참고 사이트<br>
>[[Android/Kotlin] 멀티뷰 타입 RecyclerView 구현하기](https://yunaaaas.tistory.com/61)<br>

> 바텀 네비게이션 구현 방법 참고 사이트 <br>
> [개발하는 정대리 - 취준생을 위한 안드로이드 앱만들기 바텀네비게이션 뷰, 네비게이션 AAC - Android Kotlin jetpack Tutorial (2021)](https://www.youtube.com/watch?v=4CrNKxoN_Dg)<br>

> 안드로이드 공식 사이트<br>
> [프래그먼트와 통신](https://developer.android.com/guide/fragments/communicate?hl=ko)<br>
> [대화상자](https://developer.android.com/guide/topics/ui/dialogs?hl=ko)<br>
> [Kotlin 문법](https://developer.android.com/codelabs/basic-android-kotlin-compose-functions?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-1-pathway-1%3Fhl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-functions#6)<br>
> [다른 프래그먼트와 통신](https://developer.android.com/training/basics/fragments/communicating?hl=ko)<br>
> [뷰바인딩](https://developer.android.com/topic/libraries/view-binding?hl=ko)<br>
