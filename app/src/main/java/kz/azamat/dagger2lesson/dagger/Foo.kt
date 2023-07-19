package kz.azamat.dagger2lesson.dagger

import android.util.Log
import androidx.fragment.app.Fragment
import dagger.Component
import kz.azamat.dagger2lesson.MainActivity
import javax.inject.Inject
import kotlin.math.log


class Foo @Inject constructor() {

    fun someFunc() {
        Log.e("myLog", "someFunc: Foo" )
    }
}

class Bar @Inject constructor(private val foo: Foo) {

    fun callFoo() {
        foo.someFunc()
    }

}

@Component
interface FooComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: Fragment)

}

