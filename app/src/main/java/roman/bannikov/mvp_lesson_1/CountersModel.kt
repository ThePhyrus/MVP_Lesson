package roman.bannikov.mvp_lesson_1

class CountersModel {

    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next (position: Int):Int{ //симуляция похода в API (например)
        val newResult = counters[position]++ //не сократил для наглядности
        return newResult
    }

    fun set (position: Int, value:Int) {
        counters[position]
    }


}