package com.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.core.view.isVisible
import com.practice.databinding.ActivityMainBinding
import com.practicebir.Person


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            registerBtn.setOnClickListener{
                val firstName = etName.text.toString()
                val lastName = etLName.text.toString()
                val phone = etPhone.text.toString()
                val birth = etbirth.text.toString()
                val login = etLogin.text.toString()
                val password = etPassword.text.toString()

                val person = Person(
                    firstName = firstName,
                    lastName = lastName,
                    phone = phone,
                    birthDay = birth,
                    login = login,
                    password = password
                )

                if(validate(person)){
                    val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
                    intent.putExtra("Person", person)
                    startActivity(intent)
                }
            }
        }
    }
    private fun validate(person: Person): Boolean{
        if(person.firstName.isBlank()){
            binding.etName.setBackgroundResource(R.drawable.background_edit_text_error_state)
            binding.txt.isVisible = true
            return false
        }
        return true
    }

}