package com.example.lunchschedule.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lunchschedule.R
import kotlinx.android.synthetic.main.main_fragment.*
import java.time.LocalDate
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        calendar_view.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Note: Local Date uses months 1-12 instead of 0-11
            val dateSelected = LocalDate.of(year, month+1, dayOfMonth)
            lunch_menu_text.text = viewModel.getMenu(dateSelected)
        }
        calendar_view.date = Calendar.getInstance().timeInMillis
    }
}