package kz.azamat.dagger2lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.azamat.dagger2lesson.lesson2.DaggerFooComponent
import kz.azamat.dagger2lesson.lesson2.IBar
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var iBar: IBar

    @Inject
    @Named("simple_bar") lateinit var iBar: IBar

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = DaggerFooComponent.builder().build()
        component.inject(this)
    }

}