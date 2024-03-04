package com.example.navigationcompanetuse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.example.navigationcompanetuse.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val bundle:DetailFragmentArgs by navArgs() //

        val incomingName = bundle.name
        val incomingAge= bundle.age
        val incominglenght = bundle.lenght
        val incomingSingle = bundle.single

        val urunId = bundle.urun.id
        val urunName = bundle.urun.name


        binding.textViewInfo.text = "$incomingName - $incomingAge - $incominglenght - $incomingSingle - $urunId - $urunName"

        val backPress = object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Snackbar.make(binding.textViewInfo,"Geri dönmek istiyor musunuz?",Snackbar.LENGTH_SHORT)
                    .setAction("Evet"){
                        isEnabled = false //Geri dönüş aktif
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                    .show()

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)

        return binding.root
    }


}