package com.example.myapplication6

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) {post: Post ->
            with(binding) {
                textView.text = post.author
                textView2.text = post.published
                textView3.text = post.content
                imageButton.setImageResource(
                    if (post.likedByMe) R.drawable.lk0000 else R.drawable.lk1111
                )
            }
        }
        binding.imageButton.setOnClickListener {
            viewModel.like()
            LikeClick(it)
        }
        val textView0: TextView = findViewById(R.id.textView4)
        if (l > 999999) {
            var ll = l / 1000000
            textView0.text = ll.toString() + "М"
        } else if (l > 999) {
            var ll = l / 1000
            textView0.text = ll.toString() + "К"
        } else {
            textView0.text = l.toString()
        }
        val t2: TextView = findViewById(R.id.textView5)//поделиться
        if (share > 999999) {
            var ll = share / 1000000
            t2.text = ll.toString() + "М"
        } else if (share > 999) {
            var ll = share / 1000
            t2.text = ll.toString() + "К"
        } else {
            t2.text = share.toString()
        }

        val t3: TextView = findViewById(R.id.textView6)//просмотры
        if (views > 999999) {
            var ll = views / 1000000
            t3.text = ll.toString() + "М"
        } else if (views > 999) {
            var ll = views / 1000
            t3.text = ll.toString() + "К"
        } else {
            t3.text = views.toString()
        }
    }

    var l = 999999          //лайк
    var bol = 0             //
    var share = 989         //поделиться
    var views = 2354685     //просмотры


    @SuppressLint("CutPasteId", "SetTextI18n")
    fun LikeClick(view: View) {
        bol++
        if (bol == 1) {
            l++
            findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.lk0000)
        } else if (bol == 2) {
            l--
            findViewById<ImageButton>(R.id.imageButton).setImageResource(R.drawable.lk1111)
            bol = 0
        }
        val textView: TextView = findViewById(R.id.textView4)
        textView.text = l.toString()
        val textView0: TextView = findViewById(R.id.textView4)
        if (l > 999999) {
            var ll = l / 1000000
            textView0.text = ll.toString() + "М"
        } else if (l > 999) {
            var ll = l / 1000
            textView0.text = ll.toString() + "К"
        } else {
            textView0.text = l.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun ShareClick(view: View) {
        share++
        val t2: TextView = findViewById(R.id.textView5)


        if (share > 999999) {                            // миллион
            var ll = share / 1000000
            t2.text = ll.toString() + "М"
        } else if (share > 999) {                        //тысяча
            var ll = share / 1000
            t2.text = ll.toString() + "К"
        } else {
            t2.text = share.toString()
        }
    }
}