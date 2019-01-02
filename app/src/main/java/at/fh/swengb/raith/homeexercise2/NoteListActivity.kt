package at.fh.swengb.raith.homeexercise2

import adapter.NoteListViewAdapter
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import beans.Note
import dbaccess.NoteRoomDatabase
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    private var notes = mutableListOf<Note>()
    val myAdapter = NoteListViewAdapter()
    lateinit var db: NoteRoomDatabase

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        // o Read Name and age from SP
        sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        tfUserInfo.text = "Notes for " + sharedPreferences.getString("UserName","") + ", " + sharedPreferences.getInt("UserAge",0).toString()
    }

    fun onClickAddNote(v : View)
    {
        // o Open AddNoteActivity
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        // o Read from DB
        db = NoteRoomDatabase.getDatabase(this)
        notes = db.noteDao.getAll().toMutableList()

        // o Display on RecView
        myAdapter.noteList = notes
        recView.adapter = myAdapter
        recView.layoutManager = LinearLayoutManager(this)
    }
}
