package kz.azamat.dagger2lesson.lesson2

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import kz.azamat.dagger2lesson.MainActivity
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

interface IBar
class Bar @Inject constructor() : IBar
class SecondBar @Inject constructor() : IBar

class Foo @Inject constructor(
    @FirstBar private val bar: IBar
) {
    fun foo() {

    }
}

@Module
interface BarModule2 {
//    @Binds
//    @Named("first_bar")
//    fun bindBar(bar: Bar): IBar

    @Binds
    @FirstBar
    fun bindBar(bar: Bar): IBar

    @Binds
    fun bindSecondBar(bar: Bar): IBar
}

@Module
interface BarModule {

    @Binds
    fun bindBar(bar: Bar): IBar

}

//@Module(includes = [])
@Module
class NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https...")
            .build()
        return retrofit
    }

}


@Component(modules = [BarModule::class, NetworkModule::class])
interface  FooComponent {

    fun inject(mainActivity: MainActivity)

}

//минус нужно создавать новые аннотации
@Qualifier
annotation class FirstBar