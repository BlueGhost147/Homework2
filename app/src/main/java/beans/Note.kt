package beans

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Note(@PrimaryKey var noteId : String = UUID.randomUUID().toString(), val title : String, val text : String) {

    // TODO TimeStamp

    override fun toString(): String {
        return "Note(title='$title', text='$text')"
    }
}