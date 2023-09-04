package com.marqumil.peakyblinder.ui.article

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.remote.response.ArtikelData

class ArticleAdapter(private val articlesList: List<ArtikelData>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_item_title)
        private val publishDate: TextView = itemView.findViewById(R.id.tv_item_published_date)
        private val image: ImageView = itemView.findViewById(R.id.img_poster)
        private val cvItemArticle: View = itemView.findViewById(R.id.cv_item_artikel)

        fun bind(article: ArtikelData) {
            titleTextView.text = article.judul
            publishDate.text = article.tanggalTerbit

            Glide.with(itemView.context)
                .load(article.img)
                .into(image)

            cvItemArticle.setOnClickListener {
                val intent = Intent(it.context, DetailArticleActivity::class.java)
                intent.putExtra(DetailArticleActivity.EXTRA_ARTIKEL, article)
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = articlesList[position]
        holder.bind(currentArticle)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

//    inner class ArticleViewHolder(private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(artikel: Article) {
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