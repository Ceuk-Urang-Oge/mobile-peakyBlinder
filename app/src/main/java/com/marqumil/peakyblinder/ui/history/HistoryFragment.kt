package com.marqumil.peakyblinder.ui.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {


    private lateinit var viewModel: HistoryViewModel
    private lateinit var _binding: FragmentHistoryBinding

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root



        return root
    }


}