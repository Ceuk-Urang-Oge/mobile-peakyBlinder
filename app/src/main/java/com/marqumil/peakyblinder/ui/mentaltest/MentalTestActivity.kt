package com.marqumil.peakyblinder.ui.mentaltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marqumil.peakyblinder.MainActivity
import com.marqumil.peakyblinder.R
import com.marqumil.peakyblinder.databinding.ActivityMentalTestBinding
import com.marqumil.peakyblinder.ui.doctor.ConsultationActivity

class MentalTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMentalTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMentalTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pertanyaanData: MutableList<Int> = (1..20).toList().toMutableList()

        supportActionBar?.hide()

        binding.apply {
            // back
            toolbarSubtitle.setOnClickListener {
                onBackPressed()
            }

            // get radio group value
            rgPertanyaan1.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan1SangatJarang -> {
                        pertanyaanData[1] = 1
                    }
                    R.id.rbPertanyaan1Jarang -> {
                        pertanyaanData[1] = 2
                    }
                    R.id.rbPertanyaan1KadangKadang -> {
                        pertanyaanData[1] = 3
                    }
                    R.id.rbPertanyaan1Sering -> {
                        pertanyaanData[1] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan2.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan2SangatJarang -> {
                        pertanyaanData[2] = 1
                    }
                    R.id.rbPertanyaan2Jarang -> {
                        pertanyaanData[2] = 2
                    }
                    R.id.rbPertanyaan2KadangKadang -> {
                        pertanyaanData[2] = 3
                    }
                    R.id.rbPertanyaan2Sering -> {
                        pertanyaanData[2] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan3.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan3SangatJarang -> {
                        pertanyaanData[3] = 1
                    }
                    R.id.rbPertanyaan3Jarang -> {
                        pertanyaanData[3] = 2
                    }
                    R.id.rbPertanyaan3KadangKadang -> {
                        pertanyaanData[3] = 3
                    }
                    R.id.rbPertanyaan3Sering -> {
                        pertanyaanData[3] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan4.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan4SangatJarang -> {
                        pertanyaanData[4] = 1
                    }
                    R.id.rbPertanyaan4Jarang -> {
                        pertanyaanData[4] = 2
                    }
                    R.id.rbPertanyaan4KadangKadang -> {
                        pertanyaanData[4] = 3
                    }
                    R.id.rbPertanyaan4Sering -> {
                        pertanyaanData[4] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan5.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan5SangatJarang -> {
                        pertanyaanData[5] = 1
                    }
                    R.id.rbPertanyaan5Jarang -> {
                        pertanyaanData[5] = 2
                    }
                    R.id.rbPertanyaan5KadangKadang -> {
                        pertanyaanData[5] = 3
                    }
                    R.id.rbPertanyaan5Sering -> {
                        pertanyaanData[5] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan6.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan6SangatJarang -> {
                        pertanyaanData[6] = 1
                    }
                    R.id.rbPertanyaan6Jarang -> {
                        pertanyaanData[6] = 2
                    }
                    R.id.rbPertanyaan6KadangKadang -> {
                        pertanyaanData[6] = 3
                    }
                    R.id.rbPertanyaan6Sering -> {
                        pertanyaanData[6] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan7.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan7SangatJarang -> {
                        pertanyaanData[7] = 1
                    }
                    R.id.rbPertanyaan7Jarang -> {
                        pertanyaanData[7] = 2
                    }
                    R.id.rbPertanyaan7KadangKadang -> {
                        pertanyaanData[7] = 3
                    }
                    R.id.rbPertanyaan7Sering -> {
                        pertanyaanData[7] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan8.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan8SangatJarang -> {
                        pertanyaanData[8] = 1
                    }
                    R.id.rbPertanyaan8Jarang -> {
                        pertanyaanData[8] = 2
                    }
                    R.id.rbPertanyaan8KadangKadang -> {
                        pertanyaanData[8] = 3
                    }
                    R.id.rbPertanyaan8Sering -> {
                        pertanyaanData[8] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan9.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan9SangatJarang -> {
                        pertanyaanData[9] = 1
                    }
                    R.id.rbPertanyaan9Jarang -> {
                        pertanyaanData[9] = 2
                    }
                    R.id.rbPertanyaan9KadangKadang -> {
                        pertanyaanData[9] = 3
                    }
                    R.id.rbPertanyaan9Sering -> {
                        pertanyaanData[9] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan10.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan10SangatJarang -> {
                        pertanyaanData[10] = 1
                    }
                    R.id.rbPertanyaan10Jarang -> {
                        pertanyaanData[10] = 2
                    }
                    R.id.rbPertanyaan10KadangKadang -> {
                        pertanyaanData[10] = 3
                    }
                    R.id.rbPertanyaan10Sering -> {
                        pertanyaanData[10] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan11.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan11SangatJarang -> {
                        pertanyaanData[11] = 1
                    }
                    R.id.rbPertanyaan11Jarang -> {
                        pertanyaanData[11] = 2
                    }
                    R.id.rbPertanyaan11KadangKadang -> {
                        pertanyaanData[11] = 3
                    }
                    R.id.rbPertanyaan11Sering -> {
                        pertanyaanData[11] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan12.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan12SangatJarang -> {
                        pertanyaanData[12] = 1
                    }
                    R.id.rbPertanyaan12Jarang -> {
                        pertanyaanData[12] = 2
                    }
                    R.id.rbPertanyaan12KadangKadang -> {
                        pertanyaanData[12] = 3
                    }
                    R.id.rbPertanyaan12Sering -> {
                        pertanyaanData[12] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan13.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan13SangatJarang -> {
                        pertanyaanData[13] = 1
                    }
                    R.id.rbPertanyaan13Jarang -> {
                        pertanyaanData[13] = 2
                    }
                    R.id.rbPertanyaan13KadangKadang -> {
                        pertanyaanData[13] = 3
                    }
                    R.id.rbPertanyaan13Sering -> {
                        pertanyaanData[13] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan14.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan14SangatJarang -> {
                        pertanyaanData[14] = 1
                    }
                    R.id.rbPertanyaan14Jarang -> {
                        pertanyaanData[14] = 2
                    }
                    R.id.rbPertanyaan14KadangKadang -> {
                        pertanyaanData[14] = 3
                    }
                    R.id.rbPertanyaan14Sering -> {
                        pertanyaanData[14] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan15.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan15SangatJarang -> {
                        pertanyaanData[15] = 1
                    }
                    R.id.rbPertanyaan15Jarang -> {
                        pertanyaanData[15] = 2
                    }
                    R.id.rbPertanyaan15KadangKadang -> {
                        pertanyaanData[15] = 3
                    }
                    R.id.rbPertanyaan15Sering -> {
                        pertanyaanData[15] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan16.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan16SangatJarang -> {
                        pertanyaanData[16] = 1
                    }
                    R.id.rbPertanyaan16Jarang -> {
                        pertanyaanData[16] = 2
                    }
                    R.id.rbPertanyaan16KadangKadang -> {
                        pertanyaanData[16] = 3
                    }
                    R.id.rbPertanyaan16Sering -> {
                        pertanyaanData[16] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan17.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan17SangatJarang -> {
                        pertanyaanData[17] = 1
                    }
                    R.id.rbPertanyaan17Jarang -> {
                        pertanyaanData[17] = 2
                    }
                    R.id.rbPertanyaan17KadangKadang -> {
                        pertanyaanData[17] = 3
                    }
                    R.id.rbPertanyaan17Sering -> {
                        pertanyaanData[17] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan18.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan18SangatJarang -> {
                        pertanyaanData[18] = 1
                    }
                    R.id.rbPertanyaan18Jarang -> {
                        pertanyaanData[18] = 2
                    }
                    R.id.rbPertanyaan18KadangKadang -> {
                        pertanyaanData[18] = 3
                    }
                    R.id.rbPertanyaan18Sering -> {
                        pertanyaanData[18] = 4
                    }
                }
            }
            // get radio group value
            rgPertanyaan19.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbPertanyaan19SangatJarang -> {
                        pertanyaanData[19] = 1
                    }
                    R.id.rbPertanyaan19Jarang -> {
                        pertanyaanData[19] = 2
                    }
                    R.id.rbPertanyaan19KadangKadang -> {
                        pertanyaanData[19] = 3
                    }
                    R.id.rbPertanyaan19Sering -> {
                        pertanyaanData[19] = 4
                    }
                }
            }

            try {
                // button
                btnSubmit.setOnClickListener {
                    val score = getScore(pertanyaanData)
                    val diagnose = diagnoseBaseOnScore(score)
                    alertDiagnose(diagnose)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    private fun getScore(pertanyaanData: MutableList<Int>): Int {
        return pertanyaanData.sum()
    }

    private fun diagnoseBaseOnScore(score: Int): String {
        var diagnose = ""
        when (score) {
            in 0..16 -> {
                diagnose = "Tidak ada gejala."
            }
            in 17..34 -> {
                diagnose = "Tidak ada gejala yang signifikan."
            }
            in 35 ..51 -> {
                diagnose = "Gejala ringan hingga sedang. Disarankan untuk mencari dukungan atau konseling."
            }
            in 52 ..68 -> {
                diagnose = " Gejala yang cukup mengganggu. Disarankan untuk mencari bantuan profesional."
            }
            in 69 ..100 -> {
                diagnose = "Gejala yang parah. Saran untuk segera mencari bantuan medis atau psikiater."
            }
        }
        return diagnose
    }

    private fun alertDiagnose(diagnose: String) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Hasil Diagnosa")
        builder.setMessage("$diagnose\n\nApakah Anda ingin konsultasi dengan profesional?")
        builder.setPositiveButton("Ya") { _, _ ->
            Intent(this, ConsultationActivity::class.java).also {
                startActivity(it)
            }
        }
        builder.setNegativeButton("Tidak") { _, _ ->
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()

    }
}