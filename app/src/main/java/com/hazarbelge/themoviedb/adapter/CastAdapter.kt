package com.hazarbelge.themoviedb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hazarbelge.themoviedb.R
import com.hazarbelge.themoviedb.dto.Actor

class CastAdapter(val context: Context) : RecyclerView.Adapter<CastAdapter.ViewCastHolder>() {

    var actorList : List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCastHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_items,parent,false)
        return ViewCastHolder(view)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ViewCastHolder, position: Int) {

        holder.tvActorCharacter.text = actorList[position].character
        holder.tvActorName.text = actorList[position].name
        Glide.with(context).load("https://image.tmdb.org/t/p/w220_and_h330_face/" + actorList.get(position).profile_path)
            .apply(RequestOptions().centerCrop())
            .into(holder.profile_path)
    }

    fun setActorListItems(actorList: List<Actor>){
        this.actorList = actorList;
        notifyDataSetChanged()
    }

    class ViewCastHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val profile_path: ImageView = itemView.findViewById(R.id.profile_path)
        val tvActorCharacter: TextView = itemView.findViewById(R.id.character)
        val tvActorName: TextView = itemView.findViewById(R.id.name)

    }
}
