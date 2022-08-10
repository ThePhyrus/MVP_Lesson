package roman.bannikov.mvp_lesson_1.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import roman.bannikov.mvp_lesson_1.core.navigation.UsersScreens


class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreens)
    }

    fun onBackPressedFromMainPresenter() {
        router.exit()
    }


}