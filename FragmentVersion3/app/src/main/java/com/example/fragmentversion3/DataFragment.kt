package com.example.fragmentversion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentversion3.databinding.DataFragmentBinding

class DataFragment : Fragment() {

    private lateinit var binding: DataFragmentBinding

    var data : String = ""
    set(value){
        field = value
        binding.txtData.text = field
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataFragmentBinding.inflate(inflater)
        //way 1 - communication between two fragments through Main Activity
        /*binding.btnUpdateData.setOnClickListener {
            (activity as MainActivity).sendDataToFormFragment("$data -- updated")
        }

         */

        //way 2 - communication between two fragments directly
        binding.btnUpdateData.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.formFragment)
                    as FormFragment).updateData = "$data -- updated"
        }

        return binding.root
    }
}