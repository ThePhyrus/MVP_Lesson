package roman.bannikov.mvp_lesson_1.user

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import roman.bannikov.mvp_lesson_1.repository.GithubRepository

private const val TAG: String = "@@@"

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    private val bag =  CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProgressBar()
        repository.getUsers()
            .subscribeByDefault()
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideProgressBar()
                },
                {
                    Log.d(TAG, "onFirstViewAttach: ${it.message} ")
                }
            ).disposeBy(bag)
    }

    fun onBackPressedInUserPresenter(): Boolean {
        router.exit()
        return true
    }

    private fun Disposable.disposeBy(bag: CompositeDisposable) {
        bag.add(this)
    }

    private fun <T> Single<T>.subscribeByDefault(): Single<T> {
        return this
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }

}