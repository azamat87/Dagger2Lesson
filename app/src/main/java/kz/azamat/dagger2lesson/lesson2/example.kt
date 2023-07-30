package kz.azamat.dagger2lesson.lesson2

import android.app.Application
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import kz.azamat.dagger2lesson.App
import kz.azamat.dagger2lesson.MainActivity
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

interface IBar {
    fun call()
}


class Bar @Inject constructor(): IBar {

    override fun call() {
        println("Bar call func")

    }

}

class SecondBar @Inject constructor(): IBar {
    override fun call() {
        println("SecondBar call")
    }
}

@Module
interface BarModule {

    @Binds
    fun bindBar(bar: Bar) : IBar

//    @Binds
//    @Named("second_bar")
//    fun bindSecondBar(bar: SecondBar): IBar
//
    @Binds
    @SecondBarName
    fun bindSecondBar(bar: SecondBar): IBar

}

@Module
object NetworkModule {

    @Provides
    fun provideCounter(): Counter {
        return Counter()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit() : Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.kz/")
            .build()
        return retrofit
    }
}

@Component(modules = [BarModule::class, NetworkModule::class])
interface FooComponent {

    fun inject(mainActivity: MainActivity)

}

//@Component(modules = [])
//interface AppComponent {
//
//    fun inject(application: Application)
//
//}



@Qualifier
annotation class SecondBarName
