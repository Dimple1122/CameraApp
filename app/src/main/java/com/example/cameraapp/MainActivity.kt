package com.example.cameraapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var image:ImageView?=null
    var button:Button?=null
    val REQUEST_CODE=1
    //x variable i am adding to see the changes in jenkins
    val x=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image=findViewById(R.id.imageView)
        button=findViewById(R.id.button)
        button?.setOnClickListener{
            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE),REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_CODE->{
                if(resultCode==Activity.RESULT_OK && data!=null){
                    image?.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
                else{
                    Toast.makeText(this,"Image is not captured",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}