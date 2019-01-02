package at.fh.swengb.raith.homeexercise2

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import beans.Note
import dbaccess.NoteRoomDatabase
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    lateinit var db: NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        // o Get DB
        db = NoteRoomDatabase.getDatabase(this)
    }

    fun onClickSaveNote(v : View)
    {
        // o Save Input to DB
        val noteTitle = inputNoteTitle.text.toString()
        val noteText = inputNoteText.text.toString()

        val note = Note(title = noteTitle, text = noteText)

        try {
            db.noteDao.insert(note)
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }
        catch (e : SQLiteConstraintException)
        {
            // This should never happen! Identical GUIDs
            Toast.makeText(this, "Database error!", Toast.LENGTH_SHORT).show()
        }

        // o finish Activity
        finish()
    }
}
