package roman.bannikov.mvp_lesson_1

import moxy.MvpPresenter

class CountersPresenter(private val model: CountersModel) : MvpPresenter<MainView>() {

    fun onClickCounterOne() {
        viewState.setTextOnCounterOne(model.next(0).toString())
    }

    fun onClickCounterTwo() {
        viewState.setTextOnCounterTwo(model.next(1).toString())
    }

    fun onClickCounterThree() {
        viewState.setTextOnCounterThree(model.next(2).toString())
    }

}