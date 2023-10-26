package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]

        val button = findViewById<Button>(R.id.button)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        imagesViewModel.setImages(imageArray)
//        val fragment = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ImageDisplayFragment)
//
//        button.setOnClickListener {
//            fragment.setImages(imageArray)
//        }

//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.fragmentContainerView, fragment)
//            .commit()

    }
}