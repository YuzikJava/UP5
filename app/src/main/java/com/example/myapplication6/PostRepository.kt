package com.example.myapplication6

import androidx.lifecycle.LiveData

interface  PostRepository {
    fun get(): LiveData<Post>
    fun like()
}