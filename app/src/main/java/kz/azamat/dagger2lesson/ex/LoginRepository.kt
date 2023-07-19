package kz.azamat.dagger2lesson.ex

import kz.azamat.dagger2lesson.ex.data.CloudDataSource
import javax.inject.Inject

class LoginRepository @Inject constructor(private val cloudDataSource: CloudDataSource) {

    fun rest(userParams: UserParams) {
        cloudDataSource.callRequest()
    }

}

class UserParams