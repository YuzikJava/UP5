package com.example.myapplication6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Кругосветка",
        content = "Башня, впоследствии ставшая символом Парижа, была построена в 1889 году и первоначально задумывалась как временное сооружение, служившее входной аркой парижской Всемирной выставки 1889 года.",
        published = "Сегодня в 20:23",
        likedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
}