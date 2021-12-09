package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 21.12.09 onActivityResult의 대안
        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }

        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1", "Hello Bundle")
        intent.putExtra("from2", 2021)
        //binding.btnStart.setOnClickListener { startActivity(intent) }

        // startActivityForResult는 폐기되기 때문에 아래를 사용
        //binding.btnStart.setOnClickListener { startActivityForResult(intent, 99) }

        // 21.12.09 startActivityForResult 의 대안
        binding.btnStart.setOnClickListener { activityResult.launch(intent) }


    }



//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(resultCode == RESULT_OK){
//            when(requestCode){
//                99 -> {
//                    val message = data?.getStringExtra("returnValue")
//                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
//                }
//            }
//
//        }
//    }
}