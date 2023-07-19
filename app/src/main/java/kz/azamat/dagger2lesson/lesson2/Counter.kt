package kz.azamat.dagger2lesson.lesson2

import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

@CounterScope
class Counter @Inject constructor() {

    private var  count = 0

    fun increment() {
        count++
    }

    fun getCount() = count


}

@Scope
annotation class CounterScope