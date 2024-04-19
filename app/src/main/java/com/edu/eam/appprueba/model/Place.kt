package com.edu.eam.appprueba.model

import java.util.*
import kotlin.collections.ArrayList

class Place (var id:Int,
             var name:String,
             var description:String,
             var idCreator:Int,
             var state:Boolean,
             var idCategory:Int,
             var direction:String,
             var latitude:Float, var longitude:Float,
             var idCity:Int
) {

    var images:ArrayList<String> = ArrayList()
    var phones:List<String> = ArrayList()
    var date:Date = Date()
    var schedule:ArrayList<Schedule> = ArrayList()

    override fun toString(): String {
        return "PLace(id = $id, nombre = '$name', description = '$description', idCreator = $idCreator, state = $state, idCategory = $idCategory, latitude = $latitude, longitude = $longitude, idCity = $idCity)"
    }



}