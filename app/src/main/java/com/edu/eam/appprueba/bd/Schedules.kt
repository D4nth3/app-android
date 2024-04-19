package com.edu.eam.appprueba.bd

import com.edu.eam.appprueba.model.DayWeek
import com.edu.eam.appprueba.model.Schedule

object Schedules {

    val schedules:ArrayList<Schedule> = ArrayList()

    fun getAll():ArrayList<DayWeek>{
        val allDays:ArrayList<DayWeek> = ArrayList()
        allDays.addAll(DayWeek.values())
        return allDays
    }

    fun getWeekend():ArrayList<DayWeek>{
        val allDays:ArrayList<DayWeek> = ArrayList()
        allDays.add(DayWeek.SABADO)
        allDays.add(DayWeek.DOMINGO)

        return allDays
    }

    fun obtainOnWeekdays():ArrayList<DayWeek>{
        val allDays:ArrayList<DayWeek> = ArrayList()
        allDays.add(DayWeek.LUNES)
        allDays.add(DayWeek.MARTES)
        allDays.add(DayWeek.MIERCOLES)
        allDays.add(DayWeek.JUEVES)
        allDays.add(DayWeek.VIERNES)

        return allDays
    }
}