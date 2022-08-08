package roman.bannikov.mvp_lesson_1.repository.implementations

import roman.bannikov.mvp_lesson_1.model.ThePerson
import roman.bannikov.mvp_lesson_1.repository.PersonalRepository

class PersonalRepositoryImpl : PersonalRepository {

    private val person: List<ThePerson> = emptyList()
    override fun getPerson(): List<ThePerson> {
        return person
    }

}