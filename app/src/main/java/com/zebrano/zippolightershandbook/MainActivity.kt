package com.zebrano.zippolightershandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.zebrano.zippolightershandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingObj : ActivityMainBinding
    private val adapter = LightersAdapter()
    private var index = 0
    private var editLauncher: ActivityResultLauncher<Intent>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK){
                try {
                    val item = it.data?.getSerializableExtra("zippo") as Lighter
                    adapter.addZippo(item)
                } catch (ex : Exception){
                    Log.d("AppLog","Returned lighter is null!")
                }
            }
        }
    }

    private fun init(){
        // or func() = with(bindingObj)
        bindingObj.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAddCard.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}