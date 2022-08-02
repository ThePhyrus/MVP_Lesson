package roman.bannikov.mvp_lesson_1

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()


    //Архитектурная ошибка. В качестве практического задания -- исправить

/*    fun onCounterClick(id: Int) {
        when (id) {
            R.id.btnOne -> {
                view.setCounterText(model.next(0).toString(), 1)
            }
            R.id.btnTwo -> {
                view.setCounterText(model.next(1).toString(), 1)
            }
            R.id.btnThree -> {
                view.setCounterText(model.next(2).toString(), 2)
            }
        }
    }*/

    fun onClickCounterOne(counter: Int) {
        val newResult = model.next(counter) // для наглядности, но ссылки плодиться будут
        view.setCounterText(newResult.toString(), counter)
    }

    fun onClickCounterTwo(counter: Int) {
        val newResult = model.next(counter) // для наглядности, но ссылки плодиться будут
        view.setCounterText(newResult.toString(), counter)
    }

    fun onClickCounterThree(counter: Int) {
        val newResult = model.next(counter) // для наглядности, но ссылки плодиться будут
        view.setCounterText(newResult.toString(), counter)
    }
}