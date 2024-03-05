package com.rakel.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rakel.firstapp.databinding.ActivityMainBinding
import com.rakel.firstapp.databinding.TelaLinearBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener{
            var nome = binding.edtNome.editableText.toString()

            binding.tdNome.text ="Nome:" + nome

            var anoNascimento = binding.edtAnoNascimento.editableText.toString()
            val anoAtual = LocalDateTime.now().year
            var idade = anoAtual - anoNascimento.toInt()

            binding.tdIdade.text = "Idade: ${idade}"


        }
        binding.btnEnviar.setOnClickListener{
            var email = binding.edtEmail.editableText.toString()

            var telefone = binding.edtTelefone.editableText.toString()


            if(email.contains("@") && (email.contains(".com"))){
                binding.tvEmail.text = "Email valido:" + email
            }else{
                binding.tvEmail.text="Email invalido:"
            }
            if(telefone.length == 11){
                binding.tvTel.text= "telefone valido:" + telefone
            }else{
                binding.tvTel.text= "telefone invalido :"
            }
        }
    }
}