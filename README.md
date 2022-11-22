# StopWatch
The StopWatch
(Joyce의 안드로이드 앱 프로그래밍 with 코틀린)

프로젝트명 : 
 - StopWatch
 
개발환경 :
 - minSdk : 26
 - targetSdk : 32
 
 기능 : 
  - 시작, 일시정지, 초기화, 랩타임 
  
 조작법 : 
  - [시작] 버튼을 누르면 스톱워치가 시작
  - [일시정지] 버튼을 누르면 스톱워치가 일시정지
  - [랩타임] 버튼을 누르면 시간 기록
  - [초기화] 버튼을 누르면 스톱워치 초기화
  
 핵심 구성요소 :
  - 컨스트레인트 레이아웃
  - 스레드
  
 테스트 결과 :
 
 <img src = "https://user-images.githubusercontent.com/48520160/203233465-16c6a8ba-f0bd-42ac-acb4-855dd1ae36e9.png" width = "200"/> <img src = "https://user-images.githubusercontent.com/48520160/203234049-e38613dd-2d61-499b-b2c4-1e18bcb54dcf.png" width = "200"/>
 

***

아쉬운 점 

1. 랩타임을 기록할 때 textView.text 부분에 시간을 다시 계산하는데, start()함수에서 사용된 값을 사용하려면? 어떻게 해야하나

fun recordLap() {
        ....

        textView.text = "$lap LAP : ${laptime / 6000} : ${(laptime % 6000) / 100} . ${laptime % 100}"
        ....
    } 
    
    
2. 랩타임에 기록되는 시간의 문자열이 일시정지 눌렀을 때 나오는 시간 형식처럼 나오게 하려면?
