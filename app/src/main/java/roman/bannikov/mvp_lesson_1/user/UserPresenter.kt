package roman.bannikov.mvp_lesson_1.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import roman.bannikov.mvp_lesson_1.repository.GithubRepository

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressedInUserPresenter(): Boolean {
        router.exit()
        return true
    }


}