package com.example.a1ermomentoevamovil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a1ermomentoevamovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Variables

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Registro del producto

        binding.btnRegisterProd.setOnClickListener{
            if (binding.etNameProd.text.isNotEmpty() && binding.etPriceProd.text.isNotEmpty()) {
                passScreen()
            } else Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun passScreen() {
        val intent = Intent(this,SecondActivity::class.java)
        intent.apply {
            putExtra("nameProd", binding.etNameProd.text.toString())
            putExtra("priceProd", binding.etPriceProd.text.toString().toInt())
            putExtra("newProd", binding.swNewProduct.isChecked)
        }
        startActivity(intent)
    }
}