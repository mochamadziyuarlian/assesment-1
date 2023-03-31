package org.d3if3115.mobpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if3115.mobpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.hitung.setOnClickListener{operation()}
        binding.buttonClear.setOnClickListener{clear()}
    }
    fun operation(){
        val suhu = binding.suhu1Inp.text.toString()
        if(TextUtils.isEmpty(suhu)){
            Toast.makeText(this,R.string.suhuinvalid,Toast.LENGTH_LONG).show()
        }
        val satuan = binding.radio.checkedRadioButtonId
        if (satuan == -1){
            Toast.makeText(this,R.string.radioinvalid,Toast.LENGTH_SHORT).show()
        }

        val radioCelcius = satuan == R.id.buttoncelcius
        val radioFahreinheit = satuan == R.id.buttonfahrenheit

        val cek = if(radioCelcius){
            ((9.0/5.0) * suhu.toFloat()) + 32.0
        }else {
            (1.8 / (suhu.toFloat() - 32.0))
        }

        binding.hasilperhitungan.text = getString(R.string.hasil_operasi, cek)
    }
    fun clear(){
        val suhu = binding.suhu1Inp
        val satuan = binding.radio
        val hasil = binding.hasilperhitungan

        suhu.text = null
        hasil.text = "0"
        satuan.clearCheck()

    }
}