package roman.bannikov.mvp_lesson_1.lesson3


class Creation {

    fun exec() {
        Consumer(Producer()).exec()
    }


    class Producer {
    }


    class Consumer(val producer: Producer) {
        fun exec() {
        }
    }


}