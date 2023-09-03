package com.marqumil.peakyblinder.ui.doctor

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.ItemBinding

class PsikologAdapter(private val psychologistList: List<Psikolog>) :
    RecyclerView.Adapter<PsikologAdapter.PsychologistViewHolder>() {

    inner class PsychologistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.tvPsikolog)
        val textViewAge: TextView = itemView.findViewById(R.id.tvUmur)
        val textViewSex: TextView = itemView.findViewById(R.id.tvJk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsychologistViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PsychologistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PsychologistViewHolder, position: Int) {
        val currentPsychologist = psychologistList[position]

        holder.textViewAge.text = currentPsychologist.umur
        holder.textViewName.text = currentPsychologist.nama
        holder.textViewSex.text = currentPsychologist.jk

        // Bind other psychologist information here if available
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ConsultationActivity::class.java)
            it.context.startActivity(intent)
            val phoneNumber = "+62${currentPsychologist.noHp}"
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(it.context, i, null)
        }
    }

    override fun getItemCount(): Int {
        return psychologistList.size
    }

}