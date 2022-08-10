package roman.bannikov.mvp_lesson_1.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import roman.bannikov.mvp_lesson_1.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)//todo проверить другие варианты (use logs)
interface UserView : MvpView{

    fun initList(list: List<GithubUser>)

    fun updateList(list: List<GithubUser>, page: Int)

    fun showProgressBar()

    fun hideProgressBar()
}