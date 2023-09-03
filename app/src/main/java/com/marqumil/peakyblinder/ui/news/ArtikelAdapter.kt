package com.marqumil.peakyblinder.ui.news

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.remote.response.ArticlesItem

class ArtikelAdapter(private val articlesList: List<ArticlesItem>) :
    RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {

    inner class ArtikelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_item_title)
        private val publishDate: TextView = itemView.findViewById(R.id.tv_item_published_date)
        private val image: ImageView = itemView.findViewById(R.id.img_poster)
        private val cvItemArtikel: View = itemView.findViewById(R.id.cv_item_artikel)

        fun bind(article: ArticlesItem) {
            titleTextView.text = article.title
            publishDate.text = article.publishedAt

            Glide.with(itemView.context)
                .load(article.urlToImage)
                .into(image)

            cvItemArtikel.setOnClickListener {
                val intent = Intent(it.context, DetailArtikelActivity::class.java)
                intent.putExtra(DetailArtikelActivity.EXTRA_ARTIKEL, article)
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArtikelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        val currentArticle = articlesList[position]
        holder.bind(currentArticle)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

//    inner class ArtikelViewHolder(private val binding: ItemArtikelBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(artikel: Artikel) {
//            with(binding) {
//                tvJudul.text = artikel.nama_artikel
//                tvNama.text = artikel.nama_penulis
//                shapeableImageView.setImageResource(artikel.gambar)
//
//
//            }
//        }
//    }
}