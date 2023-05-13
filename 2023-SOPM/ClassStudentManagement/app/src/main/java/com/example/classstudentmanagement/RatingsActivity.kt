package com.example.classstudentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.classstudentmanagement.databinding.ActivityRatingsBinding
import com.example.classstudentmanagement.viewmodels.RatingsViewModel

class RatingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityRatingsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_ratings)

        binding.lifecycleOwner = this
        binding.viewmodel = RatingsViewModel()
    }
}