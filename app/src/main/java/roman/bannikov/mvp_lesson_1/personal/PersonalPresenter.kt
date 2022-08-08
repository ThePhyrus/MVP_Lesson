package roman.bannikov.mvp_lesson_1.personal

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import roman.bannikov.mvp_lesson_1.repository.GithubRepository
import roman.bannikov.mvp_lesson_1.repository.PersonalRepository

class PersonalPresenter(
    private val repository: PersonalRepository,
    private val router: Router
) : MvpPresenter<PersonalView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getPerson())
    }

    fun onBackPressedInPersonalPresenter(): Boolean {
        router.exit()
        return true
    }


}