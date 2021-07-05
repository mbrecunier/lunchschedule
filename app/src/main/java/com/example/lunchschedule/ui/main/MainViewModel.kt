package com.example.lunchschedule.ui.main

import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.util.HashMap

class MainViewModel : ViewModel() {

    private var lunchMenuMap: HashMap<LocalDate, String> = hashMapOf()

    init {
        mapMenuToCalendar()
    }

    fun getMenu(date: LocalDate): String {
        return lunchMenuMap[date] ?: "Not Found"
    }

    private fun mapMenuToCalendar() {
        lunchMenuMap.clear()

        // Generate menu mapping for 1/1/21 - 12/31/21
        var date = LocalDate.of(2021, 1, 1)
        val endDate = LocalDate.of(2021, 12, 31)
        val menu: List<String> = listOf("Chicken and waffles", "Tacos", "Curry", "Pizza", "Sushi",
            "No Catering", "No Catering", "Breakfast for lunch", "Hamburgers", "Spaghetti",
            "Salmon", "Sandwiches", "No Catering", "No Catering")
        var mealIndex = 4

        while (!date.isAfter(endDate)) {
            lunchMenuMap[date] = menu[mealIndex]
            date = date.plusDays(1)
            mealIndex++
            if (mealIndex >= menu.size) mealIndex = 0
        }
    }
}