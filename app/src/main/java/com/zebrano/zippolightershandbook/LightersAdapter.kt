package com.zebrano.zippolightershandbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.zebrano.zippolightershandbook.databinding.LighterItemBinding

class LightersAdapter: RecyclerView.Adapter<LightersAdapter.LightHolder>() {
    val zippoList = ArrayList<Lighter>()

    class LightHolder(item : View) : RecyclerView.ViewHolder(item) {
        val binding = LighterItemBinding.bind(item)
        fun bind(lighter: Lighter) = with(binding) {
            im.setImageResource(lighter.imgId)
            tvTitle.text = lighter.title
            tvDescription.text = lighter.descr
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LightHolder {
        // inflate one view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lighter_item, parent, false)
        return LightHolder(view)
    }

    override fun onBindViewHolder(holder: LightHolder, position: Int) {
        holder.bind(zippoList[position])
    }

    override fun getItemCount(): Int {
        return zippoList.size
    }

    fun addZippo(lighter: Lighter){
        zippoList.add(lighter)
        notifyDataSetChanged()
    }
}