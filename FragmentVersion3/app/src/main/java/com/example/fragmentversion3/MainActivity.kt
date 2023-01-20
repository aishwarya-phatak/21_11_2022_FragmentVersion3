package com.example.fragmentversion3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var formFragment : FormFragment
    private lateinit var dataFragment: DataFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initListeners()
    }

    private fun initFragments(){
        formFragment = supportFragmentManager.findFragmentById(R.id.formFragment) as FormFragment
        dataFragment = supportFragmentManager.findFragmentById(R.id.dataFragment) as DataFragment
    }

    private fun initListeners(){
            formFragment.onDataListener = MyOnDataListener()
    }

    inner class MyOnDataListener : FormFragment.OnDataListener{
        override fun onData(data: String) {
            Toast.makeText(this@MainActivity,"MainActivity : $data",Toast.LENGTH_LONG).show()
            dataFragment.data = data
        }

    }
    //way 1
    /*fun sendDataToFormFragment(data : String){
        dataFragment.data = data
    }

    fun sendDataToDataFragment(data : String){
        formFragment.updateData = data
    }

     */
}