package com.edu.eam.appprueba.bd

import com.edu.eam.appprueba.model.User

object Users {

    private val users:ArrayList<User> = ArrayList()

    init {

        users.add(User(1, "Camilo", "camilo99", "camilo@gmail.com", "123"))
        users.add(User(2, "Luis", "luis78", "luis@gmail.com", "456"))
        users.add(User(3, "abigail", "abby80", "abigail@gmail.com", "789"))

    }

    fun list():ArrayList<User>{
        return users
    }

    fun add(user: User){
        users.add(user)
    }

    fun login(email:String, password:String): User {
        val answer = users.first { u -> u.password == password && u.email == email }
        return answer

    }

}