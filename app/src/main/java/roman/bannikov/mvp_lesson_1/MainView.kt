package roman.bannikov.mvp_lesson_1

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setTextOnCounterOne(counter: String)
    fun setTextOnCounterTwo(counter: String)
    fun setTextOnCounterThree(counter: String)
}