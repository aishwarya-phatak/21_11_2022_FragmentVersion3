package com.example.fragmentversion3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentversion3.databinding.DataFragmentBinding
import com.example.fragmentversion3.databinding.FormFragmentBinding

class FormFragment : Fragment() {
    private lateinit var binding: FormFragmentBinding

    //way 3
    interface OnDataListener{
        fun onData(data : String)
    }

    var onDataListener : OnDataListener? = null

    var updateData : String = ""
    set(value) {
        field = value
        binding.edtData.setText(field)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FormFragmentBinding.inflate(inflater)

        /*binding.btnSendData.setOnClickListener {
            (activity as MainActivity).sendDataToFormFragment(binding.edtData.text.toString())
        }
         */
        binding.btnSendData.setOnClickListener {
            (parentFragmentManager.findFragmentById(R.id.dataFragment)
                    as DataFragment).data = binding.edtData.text.toString()
        }
        return binding.root
    }
}