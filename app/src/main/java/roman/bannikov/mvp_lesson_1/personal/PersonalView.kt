package roman.bannikov.mvp_lesson_1.personal

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import roman.bannikov.mvp_lesson_1.model.ThePerson

@StateStrategyType(AddToEndSingleStrategy::class)//todo проверить другие варианты (use logs)
interface PersonalView : MvpView{

    fun initList(list: List<ThePerson>)

    fun updateList(list: List<ThePerson>, page: Int)
}