package com.example.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("noteApp", MODE_PRIVATE)


     binding.saveBtn.setOnClickListener{
         val note= binding.noteEt.text.toString()
         val editor= sharedPreferences.edit()
         editor.putString("Note",note)
         editor.apply()

         Toast.makeText(this,"note added successfully",Toast.LENGTH_SHORT).show()
         binding.noteEt.text.clear()

     }

        binding.DisplayBtn.setOnClickListener{
            val note = sharedPreferences.getString("Note","")
            binding.textTv.text = "$note"
        }

    }
}