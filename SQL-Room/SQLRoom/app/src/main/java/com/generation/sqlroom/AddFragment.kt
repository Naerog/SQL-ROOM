package com.generation.sqlroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.generation.sqlroom.data.Usuario
import com.generation.sqlroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater,container,false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonAdd.setOnClickListener{
            inserirNoBanco()
        }

        return binding.root
    }

    fun verificarCampos(nome: String, sobrenome: String, idade: String): Boolean {
        return !(nome == "" || sobrenome == "" || idade == "")
    }

    fun inserirNoBanco(){
        val nome = binding.EditNome.text.toString()
        val sobrenome = binding.EditSobrenome.text.toString()
        val idade = binding.EditIdade.text.toString()

        if(verificarCampos(nome,sobrenome,idade)){
            val user = Usuario(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuário Adicionado!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else {
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }
}