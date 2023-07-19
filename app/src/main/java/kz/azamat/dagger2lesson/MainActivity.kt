package kz.azamat.dagger2lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kz.azamat.dagger2lesson.dagger.Bar
import kz.azamat.dagger2lesson.dagger.DaggerFooComponent
import kz.azamat.dagger2lesson.dagger.Foo
import kz.azamat.dagger2lesson.ex.LoginRepository
import kz.azamat.dagger2lesson.ex.data.CloudDataSource
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var foo: Foo

    @Inject
    lateinit var bar: Bar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerFooComponent.create().inject(this)

        findViewById<TextView>(R.id.textView).setOnClickListener {
            bar.callFoo()
        }
    }


}