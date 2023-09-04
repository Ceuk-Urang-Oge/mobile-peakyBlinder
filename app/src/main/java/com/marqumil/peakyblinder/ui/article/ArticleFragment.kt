package com.marqumil.peakyblinder.ui.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marqumil.peakyblinder.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {

    private lateinit var viewModel: ArticleViewModel
    private lateinit var _binding: FragmentArticleBinding
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val root: View = binding.root


        viewModel = ArticleViewModel()

        val array = viewModel.getArticle()

        recyclerView = binding.rvArticle

        recyclerView.adapter = ArticleAdapter(array)

        recyclerView.setHasFixedSize(true)

        // Initialize the adapter here
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

}