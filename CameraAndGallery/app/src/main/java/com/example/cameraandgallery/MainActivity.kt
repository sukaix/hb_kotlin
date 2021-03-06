package com.example.cameraandgallery

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.cameraandgallery.databinding.ActivityMainBinding
import java.io.File

// 3판 소스로 모두 변경함

class MainActivity : AppCompatActivity() {

    var photoUri:Uri? = null

    lateinit var cameraPermission:ActivityResultLauncher<String>
    lateinit var storagePermission:ActivityResultLauncher<String>

    lateinit var cameraLauncher:ActivityResultLauncher<Uri>
    lateinit var galleryLauncher:ActivityResultLauncher<String>

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        storagePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if(isGranted) {
                setViews()
            } else {
                Toast.makeText(baseContext, "외부저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        cameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if(isGranted) {
                openCamera()
            } else {
                Toast.makeText(baseContext, "카메라 권한을 승인해야 카메라를 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
            }
        }

        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess  ->
            if(isSuccess) { binding.imgPreview.setImageURI(photoUri) }
        }

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            binding.imgPreview.setImageURI(uri)
        }

        storagePermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    fun setViews() {
        binding.btnCamera.setOnClickListener {
            cameraPermission.launch(Manifest.permission.CAMERA)
        }

        binding.btnGallery.setOnClickListener {
            openGallery()
        }
    }

    fun openCamera() {
        val photoFile = File.createTempFile(
            "IMG_",
            ".jpg",
            getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        )

        photoUri = FileProvider.getUriForFile(
            this,
            "${packageName}.provider",
            photoFile
        )

        cameraLauncher.launch(photoUri)
    }

    fun openGallery() {
        galleryLauncher.launch("image/*")
    }
}









//package com.example.cameraandgallery
//
//import android.app.Activity
//import android.content.Intent
//import android.graphics.Bitmap
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.provider.MediaStore
//import android.widget.Toast
//import androidx.activity.result.ActivityResult
//import androidx.activity.result.ActivityResultLauncher
//import androidx.activity.result.contract.ActivityResultContracts
//import com.example.cameraandgallery.databinding.ActivityMainBinding
//import java.util.jar.Manifest
//
//// 아래는 3판 이전판 내용이다.
//
//class MainActivity: BaseActivity() {
//
//    val PERM_STORAGE = 99 //외부 저장소 권한 처리
//    val PERM_CAMERA = 100 // 카메라 권한 처리
//    val REQ_CAMERA = 101 // 카메라 촬영 요청
//
//    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//
//
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(binding.root)
//
//            //imageView = findViewById(R.id.image)
//
//            Toast.makeText(this, "onCreate() 안 ", Toast.LENGTH_LONG).show()
//
//            //카메라에서 찍은 사진을 외부 저장소에 저장하기 위해서, 저장소 권한을 요청하는 코드
//            requirePermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERM_STORAGE)
//
//        }
//
//        override fun permissionGranted(requestCode: Int) {
//
//            when(requestCode){
//                PERM_STORAGE -> setViews()
//                PERM_CAMERA -> openCamera()
//            }
//        }
//
//        override fun permissionDenied(requestCode: Int) {
//            when(requestCode){
//                PERM_STORAGE -> {
//                    Toast.makeText(baseContext, "외부 저장소 권한을 승인해야 앱을 사용할 수 있습니다", Toast.LENGTH_LONG).show()
//                    finish()
//                }
//                PERM_CAMERA -> {
//                    Toast.makeText(baseContext, "카메라 권한을 승인해야 카메라를 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//
//
//        fun setViews(){
//
//
//
//            binding.btnCamera.setOnClickListener {
//                requirePermissions(arrayOf(android.Manifest.permission.CAMERA), PERM_CAMERA)
//            }
//        }
//
//
//        fun openCamera(){
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent, REQ_CAMERA)
//
//        }
//
//        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//            super.onActivityResult(requestCode, resultCode, data)
//            if(resultCode == RESULT_OK){
//                when(requestCode){
//                    REQ_CAMERA -> {
//                        if(data?.extras?.get("data") != null){
//                            val bitmap = data?.extras?.get("data") as Bitmap
//                            binding.imgPreview.setImageBitmap(bitmap)
//                        }
//                    }
//                }
//            }
//        }
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//



