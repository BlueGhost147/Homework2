package dbaccess

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import beans.Note

@Dao
interface NoteDao {
    @Insert
    fun insert(student: Note)

    @Query("SELECT * FROM Note")
    fun getAll() : List<Note>

}