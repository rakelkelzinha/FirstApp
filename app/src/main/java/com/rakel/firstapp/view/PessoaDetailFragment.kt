package com.rakel.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rakel.firstapp.R
import com.rakel.firstapp.databinding.FragmentAllPessoasBinding
import com.rakel.firstapp.databinding.FragmentPessoaDetailBinding
import com.rakel.firstapp.view.adapter.PessoaAdapter
import com.rakel.firstapp.viewmodel.AllPessoasViewModel
import com.rakel.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaDetailFragment : Fragment() {

    // Chamar a viewmodel para pegar os dados

    private val viewModel: PessoaViewModel by viewModels()

    // Criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Configurar o binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    // Chamar a função onviewcreated onde vamos implementar o codigo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pegar o id da pessoa que foi enviado pela AllPessoasFragment
        // Setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("idPessoa"))
        }

        //Carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner) { pessoa ->
            binding.tvNome.setText(pessoa.nome)
            binding.tvAnoNascimento.setText((LocalDateTime.now().year - pessoa.idade).toString())
            binding.tvIdade.setText(pessoa.idade.toString() + "anos")
            binding.tvFaixaEtaria.setText(pessoa.faixaEtaria)

            if (pessoa.sexo == "Masculino") {
                binding.imgBoy.visibility = View.VISIBLE
                binding.imgGirl.visibility = View.GONE
            } else {
                binding.imgBoy.visibility = View.GONE
                binding.imgGirl.visibility = View.VISIBLE
            }
        }
    }
}
