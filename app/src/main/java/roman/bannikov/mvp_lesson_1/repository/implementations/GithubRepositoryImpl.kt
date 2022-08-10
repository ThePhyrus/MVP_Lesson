package roman.bannikov.mvp_lesson_1.repository.implementations

import io.reactivex.rxjava3.core.Single
import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.repository.GithubRepository
import java.util.concurrent.TimeUnit

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("Roman"),
        GithubUser("Raimond"),
        GithubUser("Roland"),
        GithubUser("Shmoland"),
        GithubUser("Coca-Coland")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create {
            it.onSuccess(repositories)
        }.delay(3, TimeUnit.SECONDS)
    }
}