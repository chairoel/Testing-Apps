package com.idcamp.testingapps.unittest.junit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.idcamp.testingapps.R
import com.idcamp.testingapps.databinding.ActivityMyUnitTestBinding

class MyUnitTestActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMyUnitTestBinding
    private lateinit var unitTestViewModel: MyUnitTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyUnitTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        unitTestViewModel = MyUnitTestViewModel(CuboidModel())

        with(binding) {
            btnSave.setOnClickListener(this@MyUnitTestActivity)
            btnCalculateSurfaceArea.setOnClickListener(this@MyUnitTestActivity)
            btnCalculateCircumference.setOnClickListener(this@MyUnitTestActivity)
            btnCalculateVolume.setOnClickListener(this@MyUnitTestActivity)
        }
    }

    override fun onClick(v: View?) {
        val length = binding.edtLength.text.toString().trim()
        val width = binding.edtWidth.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()
        when {
            TextUtils.isEmpty(length) -> {
                binding.edtLength.error = "Field ini tidak boleh kosong"
            }

            TextUtils.isEmpty(width) -> {
                binding.edtWidth.error = "Field ini tidak boleh kosong"
            }

            TextUtils.isEmpty(height) -> {
                binding.edtHeight.error = "Field ini tidak boleh kosong"
            }

            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()
                when (v?.id) {
                    R.id.btn_save -> {
                        unitTestViewModel.save(valueLength, valueWidth, valueHeight)
                        visible()
                    }

                    R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = unitTestViewModel.getCircumference().toString()
                        gone()
                    }

                    R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = unitTestViewModel.getSurfaceArea().toString()
                        gone()
                    }

                    R.id.btn_calculate_volume -> {
                        binding.tvResult.text = unitTestViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnSave.visibility = View.GONE
    }

    private fun gone() {
        binding.btnCalculateVolume.visibility = View.GONE
        binding.btnCalculateCircumference.visibility = View.GONE
        binding.btnCalculateSurfaceArea.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
    }
}