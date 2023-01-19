package com.nandaadisaputra.dependencyinjectiondagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaadisaputra.dependencyinjectiondagger.databinding.ActivityHomeBinding
import javax.inject.Inject


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
//    private lateinit var userRepository: UserRepository
    @Inject
    lateinit var userRepository: UserRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).appComponent.inject(this)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val session = SessionManager(this)
//        userRepository = UserRepository.getInstance(session)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}