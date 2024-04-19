package com.edu.eam.appprueba.bd

import com.edu.eam.appprueba.model.Place
import com.edu.eam.appprueba.model.Schedule

object Places {

    private val places:ArrayList<Place> = ArrayList()

    init {
        val schedule1 = Schedule(1, Schedules.getAll(), 12, 20)
        val schedule2 = Schedule(1, Schedules.obtainOnWeekdays(), 9, 20)
        val schedule3 = Schedule(1, Schedules.getWeekend(),16, 23)

        val place1 = Place(1, "BBC", "pub de cerveza artesanal", 1, true, 4, "cra 12 # 25",73.21254f, -40.52568f, 1)
        place1.schedule.add(schedule3)

        val place2 = Place(2, "Hotel hilton", "Alojamiento excepsional", 3, true, 1, "cra 22n # 35",73.21254f, -40.52568f, 5)
        place2.schedule.add(schedule1)

        val place3 = Place(3, "Parque norte", "Juega con tud hijos y mascotas", 2, true, 3, "cra 5 # 24a",73.21254f, -40.52568f, 3)
        place3.schedule.add(schedule2)

        val place4 = Place(4, "Restaurante La Casa", "Como hecho en casa", 1, true, 2, "cra 14 # 87",73.21254f, -40.52568f, 4)
        place4.schedule.add(schedule2)

        val place5 = Place(5, "BBC Norte", "pub de cerveza artesanal", 2, true, 4, "cra 20n # 06",73.21254f, -40.52568f, 1)
        place4.schedule.add(schedule2)

        places.add(place1)
        places.add(place2)
        places.add(place3)
        places.add(place4)
        places.add(place5)
    }

    fun list():ArrayList<Place>{
        return  places
    }

    fun approvedList():ArrayList<Place>{
        return places.filter { p -> p.state }.toCollection(ArrayList())
    }

    fun rejectedList():ArrayList<Place>{
        return places.filter { p -> !p.state }.toCollection(ArrayList())
    }

    fun get(id:Int):Place?{
        return places.firstOrNull{p -> p.id == id}
    }

    fun searchName(name:String):ArrayList<Place>{
        return places.filter { p -> p.name.lowercase().contains(name.lowercase()) && p.state }.toCollection(ArrayList())
    }

    fun create(place: Place){
        places.add(place)
    }

    fun searchCity(cityCode:Int):ArrayList<Place>{
        return places.filter { p -> p.idCity == cityCode && p.state }.toCollection(ArrayList())
    }

    fun searchCategory(categoryCode:Int):ArrayList<Place>{
        return places.filter { p -> p.idCategory == categoryCode && p.state }.toCollection(ArrayList())
    }



}