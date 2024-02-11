package com.practice

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.databinding.ActivityMainBinding
import com.practicebir.Person

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("Person", Person::class.java) as Person
        }else{
            intent.getSerializableExtra("Person") as Person
        }
        binding.etName.setText(person.firstName)
        binding.etLName.setText(person.lastName)
        binding.etPhone.setText(person.phone)
        binding.etbirth.setText(person.birthDay)
        binding.etLogin.setText(person.login)
        binding.etPassword.setText(person.password)
    }
}