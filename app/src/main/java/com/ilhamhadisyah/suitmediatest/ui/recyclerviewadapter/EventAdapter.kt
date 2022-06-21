package com.ilhamhadisyah.suitmediatest.ui.recyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.databinding.EventCardBinding
import com.ilhamhadisyah.suitmediatest.utils.EventCardListener
import com.ilhamhadisyah.suitmediatest.utils.loadUrl


private lateinit var eventCardListener: EventCardListener

class EventAdapter() :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    var eventData = arrayListOf<EventModel>()
    fun setData(data : List<EventModel>){
        val oldSize = eventData.size
        eventData.addAll(data)
        notifyItemRangeRemoved(0,oldSize)
        notifyItemRangeInserted(0,data.size)
    }

    fun initialize(cardListener: EventCardListener) {
        eventCardListener = cardListener
    }

    class ViewHolder(private val binding: EventCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(item: EventModel) {
            with(binding) {
                eventTitle.text = item.title
                eventDate.text = item.date
                eventHour.text = item.time
                eventDesc.text = item.description
                eventThumbnail.loadUrl(item.imageUrl!!)
            }

            itemView.setOnClickListener {
                eventCardListener.onCardSelected(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        return ViewHolder(
            EventCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        holder.bindItem(eventData[position])
    }

    override fun getItemCount(): Int = eventData.size
}