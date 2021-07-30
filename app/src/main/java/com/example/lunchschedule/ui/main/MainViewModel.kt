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
        val menu: List<Menu> = listOf(
            Menu("Cheese Sticks", "Chicken and waffles", "Ice Cream"),
            Menu("Cheese Sticks", "Tacos", "Ice Cream"),
            Menu("Cheese Sticks", "Curry", "Ice Cream"),
            Menu("Cheese Sticks", "Pizza", "Ice Cream"),
            Menu("Cheese Sticks", "Sushi", "Ice Cream"),
            Menu("Cheese Sticks", "No Catering", "Ice Cream"),
            Menu("Cheese Sticks", "No Catering", "Ice Cream"),
            Menu("Cheese Sticks", "Breakfast for lunch", "Ice Cream"),
            Menu("Cheese Sticks", "Hamburgers", "Ice Cream"),
            Menu("Cheese Sticks", "Spaghetti", "Ice Cream"),
            Menu("Cheese Sticks", "Salmon", "Ice Cream"),
            Menu("Cheese Sticks", "Sandwiches", "Ice Cream"),
            Menu("Cheese Sticks", "No Catering", "Ice Cream"),
            Menu("Cheese Sticks", "No Catering", "Ice Cream")
        )
        var mealIndex = 4

        while (!date.isAfter(endDate)) {
            lunchMenuMap[date] = menu[mealIndex].displayMenuString()
            date = date.plusDays(1)
            mealIndex++
            if (mealIndex >= menu.size) mealIndex = 0
        }
    }

    data class Menu(val appetizer: String? = "Cheese Sticks", val entree: String?, val dessert: String? = "Ice Cream") {
        fun displayMenuString(): String {
            return "Appetizer: $appetizer  Entree: $entree  Dessert: $dessert"
        }
    }
}