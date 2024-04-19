package com.edu.eam.appprueba.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edu.eam.appprueba.model.Place
import com.edu.eam.appprueba.R
import com.edu.eam.appprueba.activity.DetailPlaceActivity

class PlaceAdapter(var list:ArrayList<Place>): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(var itemView:View): RecyclerView.ViewHolder(itemView), OnClickListener{

        val name:TextView = itemView.findViewById(R.id.name_place)
        val direction:TextView = itemView.findViewById(R.id.direction_place)
        val state:TextView = itemView.findViewById(R.id.state_place)
        val schedule:TextView = itemView.findViewById(R.id.schedule_place)
        val img:ImageView = itemView.findViewById(R.id.img_place)
        var placeCode:Int = 0

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(place: Place){
            name.text = place.name
            direction.text = place.direction
            state.text = "Abierto"
            schedule.text = "Cierra a las 20:00"
            placeCode = place.id
        }

        override fun onClick(p0: View?) {
            val intent = Intent( name.context, DetailPlaceActivity::class.java)
            intent.putExtra("codigo", placeCode)
            name.context.startActivity(intent)
        }

    }


}