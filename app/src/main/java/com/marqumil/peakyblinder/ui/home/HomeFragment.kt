package com.marqumil.peakyblinder.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
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
        binding.mainHomeLayout.fullScroll(View.FOCUS_UP)

        // image slider
        val images = listOf(R.drawable.img_slide_1, R.drawable.img_slide_2, R.drawable.img_slide_1)
        val viewPager = binding.viewPager
        val adapter = ImageAdapter(requireContext(), images)
        viewPager.adapter = adapter
        adapter.setViewPager(viewPager)
        indicator = binding.indicator
        indicator.setViewPager(viewPager)
        adapter.setViewPager(viewPager)

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        binding.apply {
            if (userViewModel.isUserSignedIn()) {
                tvName.text = userViewModel.getUsername().toString()
            } else {
                tvName.text = "Not logged in"
            }

            // cek kesehatan mental
            cdBgKesehatanMental.setOnClickListener {
                val intent = Intent(requireContext(), MentalTestActivity::class.java)
                startActivity(intent)
            }

            // artikel
            cdBgArtikel.setOnClickListener {
                val intent = Intent(requireContext(), ArtikelActivity::class.java)
                startActivity(intent)
            }

            // doctor
            cdBgConsultation.setOnClickListener {
                val intent = Intent(requireContext(), ConsultationActivity::class.java)
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