package roman.bannikov.mvp_lesson_1.repository.implementations

import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Roman"),
        GithubUser("Raimond"),
        GithubUser("Roland"),
        GithubUser("Shmoland"),
        GithubUser("Coca-Coland")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}