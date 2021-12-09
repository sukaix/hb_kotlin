package com.example.scoperunlet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //스코프 테스트 : apply, also
        var list = mutableListOf("Scope", "Function")

        var afterApply = list.apply {
            add("Apply")
            count()
        }
        println("반환값 apply = $afterApply")

        var afterAlso = list.also {
            it.add("Also")
            it.count()
        }
        println("반환값 also = $afterAlso")


        //스코프 테스트 : run, let, with
        list = mutableListOf("Scope", "Function")

        val lastCount = list.let {
            it.add("Run")
            it.count()
        }
        println("반환값 let = $lastCount")

        val lastItem = list.run {
            add("Run")
            get(size-1)
        }
        println("반환값 ru = $lastItem")

        val lastItemWith = with(list){
            add("With")
            get(size-1)
        }
        println("반환값 with = $lastItemWith")














    }
}