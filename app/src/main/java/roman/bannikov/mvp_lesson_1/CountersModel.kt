package roman.bannikov.mvp_lesson_1

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(position: Int): Int {//FIXME не понял, зачем эта функция в данном случае нужна
        return counters[position]
    }

    fun next(position: Int): Int { //симуляция похода в API (например)
        return ++counters[position]
    }

    //FIXME No usages found in All Places. Почему подсвечивается, как fun next(), а не серым?
    fun set(position: Int, value: Int) {
        counters[position] = value
    }


}