package kz.azamat.dagger2lesson

import kz.azamat.dagger2lesson.ex.LoginRepository
import kz.azamat.dagger2lesson.ex.UserParams
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) {


    fun login(login: String, password: String) {
        loginRepository.rest(UserParams())
    }

}