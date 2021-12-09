package com.example.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //실습1
        var myName = "홍길동"
        var myAge: Int
        myAge = 27
        myAge = myAge + 1

        Log.d("BasicSyntax", "myName = $myName, myAge = $myAge")

        //실습2
        var ball = 4
        if(ball > 3){
            Log.d("ControlFlow", "4볼로 출루합니다.")
        }else{
            Log.d("ControlFlow", "타석에서 다음 타구를 기다립니다.")
        }

        var a = 1
        var b = 2
        var c = 3

        // 1.if문 두번 사용하기
        if( a < b ){
            Log.d("ControlFlow", "1: a는 b보다 작습니다.")
        }
        if( a < c ){
            Log.d("ControlFlow", "1: a는 c보다 작습니다.")
        }

        // 2. else if 문 사용하기
        if( a < b ){
            Log.d("ControlFlow", "2: a는 b보다 작습니다.")
        }else if( a < c ){
            Log.d("ControlFlow", "2: a는 c보다 작습니다.")
        }

        //When 사용 실습
        var now = 10
        when(now){
            8 -> {
                Log.d("when", "현재 시간은 8시입니다.")
            }
            9 -> {
                Log.d("when", "현재 시간은 9시입니다.")
            }
            else -> {
                Log.d("when", "현재 시간은 9시가 아닙니다.")
            }
        }
        
        //콤마로 구분해서
        now = 9
        when(now){
            8, 9 -> {
                Log.d("when", "현재 시간은 8시 또는 9시입니다.")
            }
            else -> {
                Log.d("when", "현재 시간은 9시가 아닙니다.")
            }
        }

        // 범위를 구현
        var ageOfMichael = 19
        when(ageOfMichael){
            in 10..19 -> {
                Log.d("when", "마이클은 10대입니다.")
            }
            !in 10..19 -> {
                Log.d("when", "마이클은 10대가 아닙니다.")
            }
            else -> {
                Log.d("when", "마이클의 나이를 알 수 없습니다.")
            }
        }

        //파라미터 없는 when 사용하기
        var currentTime = 6
        when{
            currentTime == 5 -> {
                Log.d("when", "현재 시간은 5시입니다.")
            }
            currentTime > 5 -> {
                Log.d("when", "현재 시간은 5시가 넘었습니다.")
            }
            else -> {
                Log.d("when", "현재 시간은 5시 이전입니다.")
            }
        }

        //배열 1. 기본 타입 배열 선안하기
        var students = IntArray(10)
        var logArray = LongArray(10)
        var CharArray = CharArray(10)
        var FloatArray = FloatArray(10)
        var DoubleArray = DoubleArray(10)
        // arrayOf 함수를 사용하면 선언과 동시에 값을 입력할 수 있습니다.
        var intArray = intArrayOf(1,2,3,4,5,6,7,8,9,10)

        //2.문자열 타입 배열 선언하기
        var stringArray = Array(10, {item->""})
        var dayArray = arrayOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

        //3. 앞에서 선언한 students 변수에 값 넣기
        // 가. 대괄호를 사용하는 방법
        students[0] = 90
        students[1] = 91
        students[2] = 92
        students[3] = 93
        students[4] = 94
        //나. set 함수를 사용하는 방법
        students.set(5, 95)
        students.set(6, 96)
        students.set(7, 97)
        students.set(8, 98)
        students.set(9, 99)

        //4. 값 변경해보기
        intArray[6] = 137
        intArray.set(9, 200)

        //5. 배열 값 사용하기
        var seventhValue = intArray[6]
        Log.d("Array", "여덟 번째 intArray의 값은 ${seventhValue}입니다.")
        var tenthValue = intArray.get(9)
        Log.d("Array", "열 번째 intArray의 값은 ${tenthValue}입니다.")
        //6. 변수에 담지 않고 직접 사용해도 된다.
        Log.d("Array", "첫 번째 dayArray의 값은 ${dayArray[0]}입니다.")
        Log.d("Array", "여섯 번째 dayArray의 값은 ${dayArray.get(5)}입니다.")

        // Collection 프로젝트 : 리스트다루기
        // 1. 값으로 걸랙션 생성하기
        var mutableList = mutableListOf("MON", "TUE", "WED")
        //값을 추가합니다.
        mutableList.add("THU")
        //값을 꺼냅니다.
        Log.d("Collection", "mutableList의 첫번째 값은 ${mutableList.get(0)}입니다.")
        Log.d("Collection", "mutablelist의 두 번째 값은 ${mutableList.get(1)}입니다.")

        //2. 빈 컬랙션 생성하기
        var stringList = mutableListOf<String>()
        //값을 추가합니다.
        stringList.add("월")
        stringList.add("화")
        stringList.add("수")
        //값을 변경합니다.
        stringList.set(1,"요일 변경")
        //사용
        Log.d("Collection", "stringList에 입력된 두 번째 값은 ${stringList.get(1)}입니다.")
        //삭제
        stringList.removeAt(1)
        Log.d("Collection", "stringList에 입력된 두 번째 값은 ${stringList.get(1)}입니다.")
        //개수를 출력합니다.
        Log.d("Collection", "stringList에는 ${stringList.size}개의 값이 있습니다.")


        //Set 컬렉션사용하기
        //1. 셋 생성하고 값 추가하기
        var set = mutableSetOf<String>()
        set.add("JAN")
        set.add("FEB")
        set.add("MAR")
        set.add("JAN")
        //2. 전체 데이터 출력해보기
        Log.d("Collection", "Set 전체 출력 = ${set}")

        //3. 특정 값 삭제하기
        set.remove("FEB")
        Log.d("Collection", "Set 전체 출력 = ${set}")


        //CollectionMap 프로젝트 : 맵다루기
        //1. 맵 생성하기
        var map = mutableMapOf<String, String>()
        //2. 값 넣기
        map.put("키1", "값1")
        map.put("키2", "값2")
        map.put("키3", "값3")
        //3. 값 사용하기
        var variable = map.get("키2")
        Log.d("Collection", "키2의 값은 ${variable}입니다")
        //4. 값 수정하기
        map.put("키2", "두 번째 값 수정")
        Log.d("Collection", "키2의 값은 ${map.get("키2")}입니다.")
        //5. 값 삭제하기
        map.remove("키2")
        //5. 1없는 값을 불러오면 null 값이 출력된다.
        Log.d("Collection", "키2의 값은 ${map.get("키2")}입니다.")


        //For 반복문
        //1. 일반적인 반복문 사용으로 열 번 반복하기
        for(index in 1..10){
            Log.d("For","현재 숫자는 ${index}")
        }
        //2. 마지막 숫자 제외하기
        var array = arrayOf("JAN", "FEB", "MAR", "APR", "MAY", "JUN")
        for(index in 0 until array.size){
            Log.d("For", "현재 월은 ${array.get(index)}입니다.")
        }
        //3. 건너뛰기
        for(index in 0..10 step 3){
            Log.d("For", "건너뛰기: ${index}")
        }
        //4. 감소시키기
        for(index in 10 downTo 0){
            Log.d("For", "감소시키기: ${index}")
        }
        //4.1 건너뀌면서 감소시키기
        for(index in 10 downTo 0 step 3){
            Log.d("For", "건너뛰면서 감소시키기: ${index}")
        }
        //5.1 배열, 컬렉션 사용하기
        for(month in array){
            Log.d("For", "현재 월은 ${month}입니다.")
        }


        //while 반복문
        //1. 일반적인 while 사용하기
        var current = 1
        val until = 12
        while(current < until){
            Log.d("while", "현재 값은 ${current}입니다.")
            // current를 1씩 증가시켜서 열한 번 반보간 후 while 문을 빠져나갑니다.
            current = current + 1
        }

        //2. do ~ while 사용하기
        var game = 1
        val match = 6
        do{
            Log.d("while", "${game}게임 이겼습니다. 우승까지 ${match-game}게임 남았습니다.")
            game += 1
        }while (game < match)

        //3. while vs do ~ while
        // while 테스트
        game = 6
        while(game < match){
            Log.d("while", "**** while 테스트입니다. ****")
            game += 1
        }

        //do ~ while 테스트
        game = 6
        do{
            Log.d("while", "**** do ~ while 테스트입니다. ****")
            game += 1
        }while (game < match)

        //4. break 반복문 탈출하기
        for(index in 1..10){
            Log.d("while", "break > 현재 index는 $index 입니다")
            if(index >5){
                break
            }
        }

        //5. countinue 다음 반복문으로
        for(except in 1..10){
            // except가 3보다 크고 8보다 작으면 continue 명령으로 로그를 찍지않고
            // for 문의 처음으로 jmp 합니다.
            if(except > 3 && except < 8){
                continue
            }
            // 따라서, 4,5,6,7은 출력되지 않습니다.
            Log.d("while", "continue > 현재 index는 $except 입니다.")
        }

        //0. 무한루프테스트


        //함수 fun
        //-------- 함수 정의부 ----------
        //1. 반환값이 있는 함수
        fun square(x: Int): Int{
            return x*x // <- square 함수는 입력받은 값에 2를 곱해서 반환합니다.
        }

        //2. 반환값이 없는 함수
        fun printSum(x: Int, y: Int){
            Log.d("fun", "x + y = ${x + y}")
        }

        //3. 입력값 없이 반환값만 있는 함수
        fun getPi(): Double{
            return 2.14
        }

        //7. 기본값을 갖는 함수
        fun newFunction(name: String, age: Int=29, weight: Double=65.5){
            Log.d("fun", "name의 값은 ${name}입니다.")
            Log.d("fun", "age의 값은 ${age}입니다.")
            Log.d("fun", "weight의 값은 ${weight}입니다.")
        }

        //-------- 함수 사용부 ----------
        //4. 반환값이 있는 함수 square 사용하기
        var squareResult = square(30)
        Log.d("fun", "30의 제곱은 ${squareResult}입니다.")

        //5. 반환값이 없는 함수는 그냥 실행한다.
        printSum(3,5)

        //6. 입력값이 없는 함수는 그냥 실행한다.
        var PI = getPi()
        Log.d("fun", "지름이 10인 원의 둘레는 ${10 *PI}입니다.")

        //7. 기본값이 있는 함수 사용하기
        newFunction("Hello")

        //8. 파라미터 이름을 직접 지정하기
        newFunction("Michael", weight = 67.5)


        //클래스 상속 ==> 별도의 프로젝트를 만들어서 테스트한다.
        //































    }
}