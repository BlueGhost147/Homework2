package adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import at.fh.swengb.raith.homeexercise2.R
import beans.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteListViewAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var noteList = listOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        viewHolder.bindItem(note)
    }

    fun updateList() {
        notifyDataSetChanged()
    }

    fun newList(newList: List<Note>) {
        noteList = newList
        notifyDataSetChanged()
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Note) {
        itemView.item_note_tfText.text = note.text
        itemView.item_note_tfTitle.text = note.title

        //itemView.findViewById<TextView>(R.id.item_note_tfText).text = note.text
        //itemView.findViewById<TextView>(R.id.item_note_tfTitle).text = note.title
    }
}