package com.ER.tier

import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {
    fun getAllPosts(): List<Post> = postRepository.findAll()

    fun getPostById(id: Long): Post? = postRepository.findById(id).orElse(null)

    fun createPost(post: Post): Post = postRepository.save(post)

    fun updatePost(id: Long, post: Post): Post? {
        return if (postRepository.existsById(id)) {
            postRepository.save(post.copy(id = id))
        } else {
            null
        }
    }

    fun deletePost(id: Long): Boolean {
        return if (postRepository.existsById(id)) {
            postRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}