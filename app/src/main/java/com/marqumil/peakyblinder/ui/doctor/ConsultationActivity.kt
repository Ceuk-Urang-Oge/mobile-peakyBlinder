package com.marqumil.peakyblinder.ui.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.ActivityConsultationBinding

class ConsultationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsultationBinding
    private lateinit var adapter: PsikologAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConsultationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.toolbarSubtitle.setOnClickListener{
            onBackPressed()
        }

        val psychologistList = getPsychologistsList()

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PsikologAdapter(psychologistList)

    }

    private fun getPsychologistsList(): List<Psikolog> {
        val psychologistsList = ArrayList<Psikolog>()
        psychologistsList.add(Psikolog(1, "Pria", "Dr. Budi", "89501539035", "35"))
        psychologistsList.add(Psikolog(2, "Pria", "Drs. Sulis", "89501539035", "42"))
        psychologistsList.add(Psikolog(3, "Wanita", "Dr. Lina", "89501539035", "30"))
        psychologistsList.add(Psikolog(4, "Wanita", "Dra. Maya", "89501539035", "38"))
        psychologistsList.add(Psikolog(5, "Pria", "Dr. Rudi", "89501539035", "41"))
        psychologistsList.add(Psikolog(6, "Pria", "Drs. Adi", "89501539035", "29"))
        psychologistsList.add(Psikolog(7, "Wanita", "Dra. Sari", "89501539035", "27"))
        psychologistsList.add(Psikolog(8, "Wanita", "Dr. Yani", "89501539035", "33"))
        psychologistsList.add(Psikolog(9, "Pria", "Drs. Bayu", "89501539035", "36"))
        psychologistsList.add(Psikolog(10, "Wanita", "Dra. Rina", "89501539035", "39"))
        return psychologistsList
    }
}