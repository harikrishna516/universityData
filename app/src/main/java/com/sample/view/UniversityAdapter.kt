package com.sample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.sample.R
import com.sample.model.UniversityModelItem

class UniversityAdapter(private var list: List<UniversityModelItem>) :
    RecyclerView.Adapter<UniversityAdapter.UniversityItemHolder>() {

    fun updateList(newList: List<UniversityModelItem>) {
        list = newList
        notifyDataSetChanged()
    }

    class UniversityItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val universityName = itemView.findViewById<MaterialTextView>(R.id.universityName)
        val country = itemView.findViewById<MaterialTextView>(R.id.country)
        val webPage = itemView.findViewById<MaterialTextView>(R.id.webPage)
        fun bind(universityModelItem: UniversityModelItem){
            universityName.text = universityModelItem.name
            country.text = universityModelItem.country
            webPage.text = universityModelItem.web_pages[0]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return UniversityItemHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UniversityItemHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

}