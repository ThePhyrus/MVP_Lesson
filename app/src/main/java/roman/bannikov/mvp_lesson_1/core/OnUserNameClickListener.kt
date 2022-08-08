package roman.bannikov.mvp_lesson_1.core

import roman.bannikov.mvp_lesson_1.model.ThePerson


interface OnUserNameClickListener {
    fun onUserNameClick(person: ThePerson)
}