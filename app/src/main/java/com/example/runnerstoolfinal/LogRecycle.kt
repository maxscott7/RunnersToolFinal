package com.example.runnerstoolfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class logRVAdapter(
    val context: Context,
    val logClickDeleteInterface: logClickDeleteInterface,
    val logClickInterface: logClickInterface
) :
    RecyclerView.Adapter<logRVAdapter.ViewHolder>() {

    private val allLogs = ArrayList<Log>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logTV = itemView.findViewById<TextView>(R.id.idTVlog)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.log_recycle_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.logTV.setText(allLogs.get(position).logTitle)
        holder.dateTV.setText("Last Updated : " + allLogs.get(position).timeStamp)
        holder.deleteIV.setOnClickListener {
            logClickDeleteInterface.onDeleteIconClick(allLogs.get(position))
        }

        holder.itemView.setOnClickListener {
            logClickInterface.onlogClick(allLogs.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allLogs.size
    }

    fun updateList(newList: List<Log>) {
        allLogs.clear()
        allLogs.addAll(newList)
        notifyDataSetChanged()
    }
}

interface logClickDeleteInterface {
    fun onDeleteIconClick(log: Log)
}

interface logClickInterface {
    fun onlogClick(log: Log)
}