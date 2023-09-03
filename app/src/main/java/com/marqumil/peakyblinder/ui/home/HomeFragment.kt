package com.marqumil.peakyblinder.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.FragmentHomeBinding
import com.marqumil.peakyblinder.ui.auth.UserViewModel
import com.marqumil.peakyblinder.ui.doctor.ConsultationActivity
import com.marqumil.peakyblinder.ui.mentaltest.MentalTestActivity
import com.marqumil.peakyblinder.ui.news.ArtikelActivity
import me.relex.circleindicator.CircleIndicator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var indicator: CircleIndicator

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // hide action bar
        requireActivity().actionBar?.hide()


//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        binding.apply {
            // check if user username is null
            Log.d("username", userViewModel.getUsername().toString())
            if (userViewModel.getUsername().toString() == "") {
                // cut the email name before @
                val email = userViewModel.getEmail().toString()
                val index = email.indexOf("@")
                val name = email.substring(0, index)
                tvName.text = name
            } else {
                tvName.text = userViewModel.getUsername().toString()
            }

            // cek kesehatan mental
            btnRetinopathyCheck.setOnClickListener {
                val intent = Intent(requireContext(), MentalTestActivity::class.java)
                startActivity(intent)
            }

            // artikel
            btnHistory.setOnClickListener {
                val intent = Intent(requireContext(), ArtikelActivity::class.java)
                startActivity(intent)
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}