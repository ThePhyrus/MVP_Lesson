package roman.bannikov.mvp_lesson_1

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()


    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun onCounterClick(id: Int) {
        when (id) {
            R.id.btnOne -> {
                val newValue = model.next(0) // будут плодиться лишние ссылки
                view.setText(newValue.toString(), 0)
//                view.setText(model.next(0).toString(), 0) // вариант без создания лишних ссылок
            }
            R.id.btnTwo -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnThree -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}