package com.marqumil.peakyblinder.ui.retinopathy


import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.github.dhaval2404.imagepicker.ImagePicker
import com.marqumil.peakyblinder.databinding.ActivityRetinopathyBinding
import com.marqumil.peakyblinder.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import pub.devrel.easypermissions.EasyPermissions
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder

class RetinopathyActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_SIZE = 32
    }

    private  lateinit var binding: ActivityRetinopathyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetinopathyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnGallery.setOnClickListener {
            ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!

            // Use Uri object instead of File to avoid storage permissions
            binding.imageView.setImageURI(uri)
            val bitmap = uriToBitmap(uri, contentResolver)
            val resizedBitmap = Bitmap.createScaledBitmap(bitmap as Bitmap, IMAGE_SIZE, IMAGE_SIZE, true)
            classifyImage(resizedBitmap)

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }


//        Log.d("RetinoImage", extras.toString() + " " + requestCode + " " + resultCode + " " + data.toString())
//        if (requestCode == IMAGE_CHOOSE && resultCode == RESULT_OK && data != null) {
//            val imageBitmap = extras?.get("data")
//            binding.imageView.setImageBitmap(imageBitmap as Bitmap)
//            Log.d("RetinoImages", imageBitmap.toString())
//            // resize image bitmap to 32x32
//            val resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, IMAGE_SIZE, IMAGE_SIZE, true)
//            classifyImage(resizedBitmap)
//        } else if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            val imageBitmap = extras?.get("data")
//            binding.imageView.setImageBitmap(imageBitmap as Bitmap)
//            Log.d("RetinoImages", imageBitmap.toString())
//            // resize image bitmap to 32x32
//            val resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, IMAGE_SIZE, IMAGE_SIZE, true)
//            classifyImage(resizedBitmap)
//        }
    }

    private fun classifyImage(bitmap: Bitmap){
        val model = Model.newInstance(this)

        // Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

        val byteBuffer = ByteBuffer.allocateDirect(224 * 224 * 3 * 4)
        byteBuffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(IMAGE_SIZE * IMAGE_SIZE)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        var pixel = 0
        for(i in IMAGE_SIZE - 1 downTo 0){
            for(j in 0 until IMAGE_SIZE){
                val pixelVal = pixels[pixel++]

                byteBuffer.putFloat(((pixelVal shr 16 and 0xFF) * (1.0f / 1)))
                byteBuffer.putFloat(((pixelVal shr 8 and 0xFF) * (1.0f / 1)))
                byteBuffer.putFloat(((pixelVal and 0xFF) * (1.0f / 1)))
            }
        }

        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        val confidences = outputFeature0.floatArray
        var maxPos = 0
        var maxConfidences = 0.0f
        for (i in confidences.indices) {
            if (confidences[i] > maxConfidences) {
                maxConfidences = confidences[i]
                maxPos = i
            }
        }

        // make array for label
        val labels = arrayOf(
            "Mild (Mild Diabetic Retinopathy)",
            "No DR (No Diabetic Retinopathy)",
            "Moderate (Moderate Diabetic Retinopathy)",
            "Proliferative DR (Proliferative Diabetic Retinopathy)",
            "Severe (Severe Diabetic Retinopathy)")

        binding.classified.text = labels[maxPos]


        // save the result to textview
        binding.result.text = outputFeature0.floatArray[0].toString()
        Log.d("output", outputFeature0.floatArray[0].toString())


        // Releases model resources if no longer used.
        model.close()
    }


    fun uriToBitmap(uri: Uri, contentResolver: ContentResolver): Bitmap? {
        var inputStream: InputStream? = null
        try {
            inputStream = contentResolver.openInputStream(uri)
            return BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStream?.close()
        }
        return null
    }
}


