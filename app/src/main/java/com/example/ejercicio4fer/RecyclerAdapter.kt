package com.example.ejercicio4fer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio4fer.databinding.ItemListBinding

class RecyclerAdapter(private val onClickListener: OnClickListener) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    private var characters: MutableList<Characters> = ArrayList()
    private lateinit var context: Context

    fun setData(characterList: MutableList<Characters>, context: Context) {
        this.characters = characterList
        this.context = context
    }

    override fun onBindViewHolder(holderMy: MyViewHolder, position: Int) {
        val item = characters[position]
        holderMy.bind(item, context)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(
            ItemListBinding.inflate(
                layoutInflater,
                parent,
                false
            ).root,
            onClickListener
        )
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    class MyViewHolder(view: View, private var onClickListener: OnClickListener) : RecyclerView.ViewHolder(view) {
        private val binding = ItemListBinding.bind(view)

        fun bind(character: Characters, context: Context) {
            binding.tvCharName.text = character.charName
            binding.tvCharDesc.text = character.charDescription
            binding.ivCharImage.setImageResource(character.charImage!!)

            itemView.setOnClickListener {
                onClickListener.onItemClickListener(character)
            }
        }
    }
}