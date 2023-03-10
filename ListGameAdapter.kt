package com.example.tugasakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListGameAdapter(private val listGame: ArrayList<Game>) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_game, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val game = listGame[position]

        Glide.with(holder.itemView.context)
            .load(game.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = game.name
        holder.tvDetail.text = game.detail

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listGame[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {

        return listGame.size

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvName: TextView = itemView.findViewById(R.id.item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)


    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Game)
    }

}