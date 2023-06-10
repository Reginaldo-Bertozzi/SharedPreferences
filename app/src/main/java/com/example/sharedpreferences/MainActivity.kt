package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("valores", Context.MODE_PRIVATE)
        val valor = sharedPreferences.getString("valor","")

        binding.textValor.setText(valor)

        binding.buttonGravar.setOnClickListener {
            val novoValor = binding.editValor.text.toString()
            binding.textValor.setText(novoValor)

            val editor = sharedPreferences.edit()
            editor.putString("valor", novoValor)
            editor.apply()
        }
    }
}