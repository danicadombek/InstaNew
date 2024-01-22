package com.example.instaclone.data

class Event<out T>(private val content: T) {
    private var hasBeenHandled = false
        private set

    fun getContentOrNull(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}