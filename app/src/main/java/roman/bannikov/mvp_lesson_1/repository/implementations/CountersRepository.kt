package roman.bannikov.mvp_lesson_1.repository.implementations

class CountersRepository {

    private val counters = mutableListOf(0, 0, 0)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int { //симуляция похода в API (например)
        return ++counters[position]
    }


    fun set(position: Int, value: Int) {
        counters[position] = value
    }


}