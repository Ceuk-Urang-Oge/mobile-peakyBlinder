package com.marqumil.peakyblinder.ui.article

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.marqumil.peakyblinder.databinding.ActivityDetailArtikelBinding
import com.marqumil.peakyblinder.remote.response.ArticlesItem
import com.marqumil.peakyblinder.remote.response.ArtikelData

class DetailArticleActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ARTIKEL = "extra_artikel"
    }

    private lateinit var binding: ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val artikel = intent.getSerializableExtra(EXTRA_ARTIKEL) as? ArtikelData
        if (artikel != null) {
            Glide.with(binding.imageFilterView2.context)
                .load(artikel.img)
                .into(binding.imageFilterView2)
            binding.judul.text = artikel.judul
            binding.penulis.text = artikel.author
            binding.isi.text = artikel.isi

            Log.d("DetailArticleActivity", artikel.toString())
        }


    }


}