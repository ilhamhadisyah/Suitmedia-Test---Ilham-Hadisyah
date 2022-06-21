package com.ilhamhadisyah.suitmediatest.ui.recyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import com.ilhamhadisyah.suitmediatest.databinding.GuestCardBinding
import com.ilhamhadisyah.suitmediatest.utils.RecyclerViewItemSelected
import com.ilhamhadisyah.suitmediatest.utils.loadUrl

private lateinit var recyclerViewItemSelected: RecyclerViewItemSelected

class GuestAdapter : PagedListAdapter<GuestModel, GuestAdapter.ViewHolder>(DIFF_CALLBACK) {
    fun initialize(listener: RecyclerViewItemSelected) {
        recyclerViewItemSelected = listener
    }

    class ViewHolder(private val binding: GuestCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guestModel: GuestModel) {
            binding.guestAvatar.loadUrl(guestModel.avatar!!)
            binding.guestName.text = "${guestModel.firstName} ${guestModel.lastName}"

            itemView.setOnClickListener {
                recyclerViewItemSelected.onItemSelected(guestModel)
            }
        }


    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GuestModel>() {
            override fun areItemsTheSame(oldItem: GuestModel, newItem: GuestModel): Boolean {
                return oldItem.id.toString() == newItem.id.toString()
            }

            override fun areContentsTheSame(oldItem: GuestModel, newItem: GuestModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItem(position) != null) {
            holder.bind(getItem(position)!!);
        } else {
            // Null defines a placeholder item - PagedListAdapter will automatically invalidate
            // this row when the actual object is loaded from the database
        }
        holder.bind(getItem(position) as GuestModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GuestCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}