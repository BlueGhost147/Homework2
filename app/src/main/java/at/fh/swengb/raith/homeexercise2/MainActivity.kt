package at.fh.swengb.raith.homeexercise2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note_list.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        // o Read Name and age from SP and set as default value
        sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        inputName.setText(sharedPreferences.getString("UserName",""))
        inputAge.setText(sharedPreferences.getInt("UserAge",0).toString())
    }

    fun onClickSave(v : View)
    {
        // o Save Input
        try {
            val name = inputName.text.toString()
            val age = inputAge.text.toString().toInt()

            sharedPreferences.edit().putString("UserName", name).apply()
            sharedPreferences.edit().putInt("UserAge", age).apply()

            // o Redirect Activity
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
        catch (e : ClassCastException)
        {
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show()
        }
    }


}
