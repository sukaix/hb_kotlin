package com.example.base

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.example.base.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : BaseActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {

            Toast.makeText(baseContext, "클릭", Toast.LENGTH_LONG).show()

            requirePermission(arrayOf(android.Manifest.permission.CAMERA), 10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Toast.makeText(baseContext, "requestCode : $requestCode", Toast.LENGTH_LONG).show()

        if(requestCode == 10){
            if(resultCode == Activity.RESULT_OK){
                Log.d("카메라", "촬영 성공")
            }else{
                Log.d("카메라", "촬영 실패")
            }
        }
    }

    override fun permissionGranted(requestCode: Int) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 99)
    }

    override fun permissionDenied(requestCode: Int) {
        Toast.makeText(baseContext, "권한 거부됨", Toast.LENGTH_LONG).show()
    }
}