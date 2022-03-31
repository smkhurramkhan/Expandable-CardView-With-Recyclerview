package com.example.expandablecardview

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandablecardview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var dataList = mutableListOf<ItemExercises>()
    private var adapterDetails: AdapterDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        setupAdapter()

        binding.arrowBtn.setOnClickListener {

            if (binding.expandableView.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(binding.cardView, AutoTransition())
                binding.expandableView.visibility = View.VISIBLE
                binding.arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
            } else {
                TransitionManager.beginDelayedTransition(binding.cardView, AutoTransition())
                binding.expandableView.visibility = View.GONE
                binding.arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp)
            }
        }

    }

    private fun setupAdapter() {
        adapterDetails = AdapterDetails(
            dataList = dataList,
            context = this
        )
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mRecyclerView.adapter = adapterDetails
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun loadData() {
        dataList.add(ItemExercises("Cardio", "30 seconds with 30 seconds of rest"))
        dataList.add(ItemExercises("Calves", "30 seconds with 30 seconds of rest"))
        dataList.add(ItemExercises("Thighs", "30 seconds with 30 seconds of rest"))
        dataList.add(ItemExercises("Burnout", "30 seconds with 30 seconds of rest"))
        dataList.add(ItemExercises("Aerobics", "30 seconds with 30 seconds of rest"))
    }
}