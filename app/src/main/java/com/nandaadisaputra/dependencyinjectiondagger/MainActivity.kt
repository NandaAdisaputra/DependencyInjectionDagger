package com.nandaadisaputra.dependencyinjectiondagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaadisaputra.dependencyinjectiondagger.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userRepository: UserRepository
//    @Inject
//    lateinit var userRepository2: UserRepository
    lateinit var binding: ActivityMainBinding
//    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Jangan lupa untuk meng-inject component sebelum super.onCreate terlebih dahulu.
        (application as MyApplication).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        userRepository.checkInstance()
//        userRepository2.checkInstance()

//        val session = SessionManager(this)
//        userRepository = UserRepository.getInstance(session)

        if (userRepository.isUserLogin()) {
            moveToHomeActivity()
        }

        binding.btnLogin.setOnClickListener {
            saveSession()
        }
    }

    private fun saveSession() {
        userRepository.loginUser(binding.edUsername.text.toString())
        moveToHomeActivity()
    }

    private fun moveToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
