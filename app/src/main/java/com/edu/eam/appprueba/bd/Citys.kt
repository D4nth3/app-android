package com.edu.eam.appprueba.bd

import com.edu.eam.appprueba.model.City

object Citys {

    private val citys:ArrayList<City> = ArrayList()

    init {
        citys.add(City (1, "Armenia"))
        citys.add(City (2, "Pereira"))
        citys.add(City (3, "Manizales"))
        citys.add(City (4, "Medellin"))
        citys.add(City (5, "Cali"))

    }

    fun list():ArrayList<City>{
        return citys
    }

    fun findById(id:Int):City?{
        return citys.firstOrNull{c -> c.id == id}
    }
}