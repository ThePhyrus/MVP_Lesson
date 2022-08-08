package roman.bannikov.mvp_lesson_1.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import roman.bannikov.mvp_lesson_1.TheApp
import roman.bannikov.mvp_lesson_1.adapters.UserAdapter
import roman.bannikov.mvp_lesson_1.core.OnBackPressedListener
import roman.bannikov.mvp_lesson_1.core.OnUserNameClickListener
import roman.bannikov.mvp_lesson_1.databinding.FragmentUserListBinding
import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.repository.implementations.GithubRepositoryImpl

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener, OnUserNameClickListener {

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

    override fun onUserNameClick(name: String) {

    }

}





