package roman.bannikov.mvp_lesson_1.repository

import roman.bannikov.mvp_lesson_1.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}