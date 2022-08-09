package roman.bannikov.mvp_lesson_1.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import roman.bannikov.mvp_lesson_1.TheApp
import roman.bannikov.mvp_lesson_1.core.OnBackPressedListener
import roman.bannikov.mvp_lesson_1.databinding.FragmentUserListBinding
import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.repository.implementations.GithubRepositoryImpl
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding get() = _binding!!
    private val adapter = UserAdapter()

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), router = TheApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
        showDelayExample()
    }

    private fun showDelayExample() {
        val observableNames = Observable.just(
            "One",
            "Two",
            "One",
            "Two",
            "Three",
            "Four",
            "One",
            "Two",
            "Three",
            "Four"
        )

        observableNames
            .flatMap { element ->
                val delay = Random.nextInt(10000)
                return@flatMap getUserInfo(element)
                    .delay(delay.toLong(), TimeUnit.MILLISECONDS)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    binding.tvResult.text = it.toString()
                    println(it)
                },
                { error ->
                    println(error)
                }
            )
    }

    private fun getUserInfo(name: String): Observable<List<String>> {
        return Observable.just(listOf(name, "email"))
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun updateList(list: List<GithubUser>, page: Int) {
        //позже пригодится
    }

    override fun onBackPressedFromInterface(): Boolean {
        return presenter.onBackPressedInUserPresenter()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}





