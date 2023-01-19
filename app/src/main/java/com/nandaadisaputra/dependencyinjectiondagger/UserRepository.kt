package com.nandaadisaputra.dependencyinjectiondagger

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

//class UserRepository(private val session: SessionManager) {

//Sudah tidak ada lagi fungsi getInstance. Anda cukup menambahkan annotation @Singleton.
@Singleton
class UserRepository @Inject constructor(private val session: SessionManager) {
//    fun checkInstance() = Log.d("Singleton", "checkInstance: $this")
    //TODO menghapus kode untuk membuat Singleton yang secara manual.
//    companion object {
//        @Volatile
//        private var instance: UserRepository? = null
//
//        fun getInstance(session: SessionManager): UserRepository =
//            instance ?: synchronized(this) {
//                instance ?: UserRepository(session)
//            }
//    }

    fun loginUser(username: String) {
        session.createLoginSession()
        session.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = session.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = session.isLogin

    fun logoutUser() = session.logout()
}
