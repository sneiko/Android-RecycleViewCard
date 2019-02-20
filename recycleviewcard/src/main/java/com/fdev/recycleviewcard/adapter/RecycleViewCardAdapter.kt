package com.fdev.recycleviewcard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fdev.recycleviewcard.R
import com.fdev.recycleviewcard.model.RecycleViewCardModel
import kotlinx.android.synthetic.main.recycle_view_card_item.view.*

/*
 * -
 * Project: RecycleViewCardExample
 * Package: com.fdev.recycleviewcard
 * -
 * Author: Neikovich Sergey
 * Email: s_neiko@outlook.com
 * Skype: jastair & Telegram: @sneiko
 * -
 * Date: 20.02.2019
 */
class RecycleViewCardAdapter(
        var data: List<RecycleViewCardModel>,
        val iRecycleViewCardAdapter: IRecycleViewCardAdapter) :
        RecyclerView.Adapter<RecycleViewCardAdapter.RecycleViewCardAdapterViewHolder>() {

    interface IRecycleViewCardAdapter {
        fun onItemClick(view: View, id: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewCardAdapterViewHolder {
        return RecycleViewCardAdapterViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycle_view_card_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecycleViewCardAdapterViewHolder, position: Int) = holder.bind(data[position], iRecycleViewCardAdapter)

    fun swapData(data: List<RecycleViewCardModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    class RecycleViewCardAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RecycleViewCardModel, iRecycleViewCardAdapter: IRecycleViewCardAdapter) = with(itemView) {

            itemView.avatar.setImageBitmap(item.avatar)
            itemView.username.text = item.username
            itemView.description.text = item.description
            itemView.info.text = item.info

            setOnClickListener {
                iRecycleViewCardAdapter.onItemClick(it, item.id)
            }
        }
    }
}