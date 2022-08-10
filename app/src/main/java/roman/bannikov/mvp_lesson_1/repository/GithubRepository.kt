package roman.bannikov.mvp_lesson_1.repository

import io.reactivex.rxjava3.core.Single
import roman.bannikov.mvp_lesson_1.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}