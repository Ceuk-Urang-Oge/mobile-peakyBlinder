package com.marqumil.peakyblinder.ui.news

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.marqumil.peakyblinder.databinding.ActivityDetailArtikelBinding
import com.marqumil.peakyblinder.remote.response.ArticlesItem

class DetailArtikelActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ARTIKEL = "extra_artikel"
    }

    private lateinit var binding: ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val artikel = intent.getSerializableExtra(EXTRA_ARTIKEL) as? ArticlesItem
        if (artikel != null) {
            Glide.with(binding.imageFilterView2.context)
                .load(artikel.urlToImage)
                .into(binding.imageFilterView2)
            binding.judul.text = artikel.title
            binding.penulis.text = artikel.author
            binding.isi.text = artikel.content.toString()
        }


    }


}