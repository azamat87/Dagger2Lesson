package kz.azamat.dagger2lesson

import android.app.Application
import dagger.Component
import javax.inject.Singleton

class App: Application() {


}

@Singleton
@Component
interface AppComponent {

}