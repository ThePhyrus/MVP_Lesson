package roman.bannikov.mvp_lesson_1.repository

import roman.bannikov.mvp_lesson_1.model.ThePerson

interface PersonalRepository {
    fun getPerson(): List<ThePerson>
}