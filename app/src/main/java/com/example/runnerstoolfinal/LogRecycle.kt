package com.example.runnerstoolfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allLogs = ArrayList<Log>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
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
        holder.noteTV.setText(allLogs.get(position).noteTitle)
        holder.dateTV.setText("Last Updated : " + allLogs.get(position).timeStamp)
        holder.deleteIV.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allLogs.get(position))
        }

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allLogs.get(position))
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

interface NoteClickDeleteInterface {
    fun onDeleteIconClick(log: Log)
}

interface NoteClickInterface {
    fun onNoteClick(log: Log)
}