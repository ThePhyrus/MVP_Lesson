package roman.bannikov.mvp_lesson_1

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class TheApp : Application() {

    companion object {
        lateinit var instance: TheApp
    }

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    val navHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}