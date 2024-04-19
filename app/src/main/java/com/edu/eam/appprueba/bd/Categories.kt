package com.edu.eam.appprueba.bd

import com.edu.eam.appprueba.model.Category
import com.edu.eam.appprueba.model.User

object Categories {

    private val categories:ArrayList<Category> = ArrayList()

    init {
        categories.add(Category(1, "Hotel", "\uf594"))
        categories.add(Category(2, "Restaurant", "\uf2e7"))
        categories.add(Category(3, "Park", "\uf1bb"))
        categories.add(Category(4, "Bar", "\uf0fc"))
    }

    fun list():ArrayList<Category>{
        return categories
    }

    fun findById(id:Int):Category?{
        return categories.firstOrNull {c -> c.id == id}


    }
}