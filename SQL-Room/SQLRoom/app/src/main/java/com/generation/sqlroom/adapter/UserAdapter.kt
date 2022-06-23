package com.generation.sqlroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.sqlroom.data.Usuario
import com.generation.sqlroom.databinding.CardLayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    class UserViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    private var listUser = emptyList<Usuario>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false
        ))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.binding.textID.text = user.id.toString()
        holder.binding.textNome.text = user.nome.toString()
        holder.binding.textSobrenome.text = user.sobrenome.toString()
        holder.binding.textIdade.text = user.idade.toString()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun setList(list: List<Usuario>){
        listUser = list
        notifyDataSetChanged()
    }
}