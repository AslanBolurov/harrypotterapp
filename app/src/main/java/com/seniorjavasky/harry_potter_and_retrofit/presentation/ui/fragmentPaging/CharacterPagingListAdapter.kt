package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seniorjavasky.harry_potter_and_retrofit.databinding.CharacterItemBinding
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem

class CharacterPagingListAdapter
    : ListAdapter<CharacterPagingItem,
        CharacterPagingListAdapter.CharacterListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterListViewHolder {

        val binding=
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: CharacterListViewHolder, position: Int
    ) {
        val characterItem = getItem(position)
        holder.binding.imageCharacter.load(characterItem.imageUrl)
        holder.binding.tvName.text = characterItem.name
        holder.binding.tvHouse.text = characterItem.hogwartsHouse

    }
    inner class CharacterListViewHolder(
        val binding:CharacterItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val callback = object : DiffUtil.ItemCallback<CharacterPagingItem>() {
            override fun areItemsTheSame(oldItem: CharacterPagingItem, newItem: CharacterPagingItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterPagingItem, newItem: CharacterPagingItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}


