package com.example.a1ermomentoevamovil

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.a1ermomentoevamovil.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    //Variables

    private lateinit var binding: ActivitySecondBinding
    private lateinit var product: Product
    private lateinit var handlerProcess: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handlerProcess = Handler(mainLooper)
        intent.apply {
            product = Product(getStringExtra("nameProd").toString(), getIntExtra("priceProd",0),getBooleanExtra("newProd",true))
        }
        //Comenzar la carga de la barra de progreso
        try {
            startCount()
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun startCount() {
        binding.tvCount.text = "1"
        Thread{
            try {
                for(i in 2..10) {
                    Thread.sleep(1000)
                    handlerProcess.post{
                        binding.apply {
                            if (i != 10) tvCount.text = "$i"
                            else tvCount.text = "Finalizado"
                            pbProgress.progress = i * 10
                        }
                    }
                }
                handlerProcess.post{
                    binding.tvDataProduct.text = product.showInformation()
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }
}