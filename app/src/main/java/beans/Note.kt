package beans

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Note(@PrimaryKey var noteId : String = UUID.randomUUID().toString(), var title : String, val text : String) {

    init {
        if (title == "")
        {
            title = "Untitled"
        }
    }
    // TODO TimeStamp

    override fun toString(): String {
        return "Note(title='$title', text='$text')"
    }
}