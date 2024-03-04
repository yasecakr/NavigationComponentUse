package com.example.navigationcompanetuse

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.navigationcompanetuse.databinding.FragmentHomePageBinding
import com.google.android.material.snackbar.Snackbar

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        binding.buttonDetail.setOnClickListener {
         //   Snackbar.make(it,"Hi!",Snackbar.LENGTH_SHORT).show()
            val urun = Urunler(100,"TV")
            val gecis = HomePageFragmentDirections.detailPass(urun = urun, name = "Deniz",age = 23,lenght = 1.73f , single= true)


            Navigation.findNavController(it).navigate(gecis)
        }

        binding.buttonShow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.bottomSheetPress)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Yaşam Döngüsü","onCreate")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Yaşam Döngüsü","onPause")

    }

    override fun onResume() {
        super.onResume()
        Log.e("Yaşam Döngüsü","onResume")

    }



}