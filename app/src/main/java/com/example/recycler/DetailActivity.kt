package com.example.recycler

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity: AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var imageView: ImageView

    private lateinit var btn_volver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewName)
        imageView = findViewById(R.id.imageViewDetalle)

        btn_volver = findViewById(R.id.btn_volver)


        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val url = bundle?.getString("url") ?: ""

        textViewName.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)

        btn_volver.setOnClickListener{
            finish()
        }

}
}