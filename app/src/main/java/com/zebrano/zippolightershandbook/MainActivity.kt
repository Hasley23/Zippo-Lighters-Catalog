package com.zebrano.zippolightershandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.zebrano.zippolightershandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingObj : ActivityMainBinding
    private val adapter = LightersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        init()
    }

    private fun init(){
        // or func() = with(bindingObj)
        bindingObj.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
        }
    }
}