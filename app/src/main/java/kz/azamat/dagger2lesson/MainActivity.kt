package kz.azamat.dagger2lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kz.azamat.dagger2lesson.lesson2.*
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    @SecondBarName
    lateinit var iBar: IBar

//    @Inject
//    @Named("simple_bar") lateinit var iBar: IBar

//    @Inject
//    lateinit var retrofit: Retrofit

    @Inject
    lateinit var service: ApiService

    @Inject
    lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component = DaggerFooComponent.builder().build()
        component.inject(this)

        val tv = findViewById<TextView>(R.id.textView)
        findViewById<Button>(R.id.buttonIncrement).setOnClickListener {
            counter.increment()
            tv.text = counter.getCount().toString()
        }
    }

}