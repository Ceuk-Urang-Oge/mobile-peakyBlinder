package com.marqumil.peakyblinder.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.FragmentHomeBinding
import com.marqumil.peakyblinder.ui.article.ArticleFragment
import com.marqumil.peakyblinder.ui.article.ArticleViewModel
import com.marqumil.peakyblinder.ui.auth.UserViewModel
import com.marqumil.peakyblinder.ui.history.HistoryFragment
import com.marqumil.peakyblinder.ui.profile.ProfileFragment
import com.marqumil.peakyblinder.ui.retinopathy.RetinopathyActivity
import me.relex.circleindicator.CircleIndicator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var indicator: CircleIndicator
    private lateinit var articleViewModel: ArticleViewModel

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
            if (userViewModel.getUsername().toString() == "" || userViewModel.getUsername().toString() == "null" || userViewModel.getUsername().toString() == " " || userViewModel.getUsername().toString() == null) {
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
                // move to other fragment
                val intent = Intent(requireContext(), RetinopathyActivity::class.java)
                startActivity(intent)
                Toast.makeText(requireContext(), "Retinopathy Check", Toast.LENGTH_SHORT).show()
            }

            // artikel
            btnHistory.setOnClickListener {

                // move to other fragment
                val supportFragmentManager = requireActivity().supportFragmentManager
                //val newFragment = HistoryFragment()
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, HistoryFragment(), "history")
                        .addToBackStack(null)
                        .commit()

                }

            }

        }

        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        val array = articleViewModel.getArticle()
        binding.apply {
            imgPoster.setImageResource(array[0].img)
            tvItemTitle.text = array[0].judul
            tvItemPublishedDate.text = array[0].tanggalTerbit
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}