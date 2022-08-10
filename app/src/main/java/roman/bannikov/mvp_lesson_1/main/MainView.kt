package roman.bannikov.mvp_lesson_1.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)//todo проверить другие варианты (use logs) 0:40
interface MainView : MvpView