package roman.bannikov.mvp_lesson_1.personal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import roman.bannikov.mvp_lesson_1.R
import roman.bannikov.mvp_lesson_1.TheApp
import roman.bannikov.mvp_lesson_1.adapters.PersonalAdapter
import roman.bannikov.mvp_lesson_1.core.OnBackPressedListener
import roman.bannikov.mvp_lesson_1.core.OnUserNameClickListener
import roman.bannikov.mvp_lesson_1.databinding.FragmentPersonalBinding
import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.model.ThePerson
import roman.bannikov.mvp_lesson_1.repository.PersonalRepository
import roman.bannikov.mvp_lesson_1.repository.implementations.GithubRepositoryImpl
import roman.bannikov.mvp_lesson_1.repository.implementations.PersonalRepositoryImpl
import roman.bannikov.mvp_lesson_1.user.UserFragment
import roman.bannikov.mvp_lesson_1.user.UserPresenter
import roman.bannikov.mvp_lesson_1.user.UserView


class PersonalFragment : MvpAppCompatFragment(), PersonalView, OnBackPressedListener, OnUserNameClickListener {

    private var _binding :FragmentPersonalBinding? = null
    private val binding: FragmentPersonalBinding get() = _binding!!
    private val adapter = PersonalAdapter()

    private val presenter: PersonalPresenter by moxyPresenter {
        PersonalPresenter(PersonalRepositoryImpl(), router = TheApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            layoutPersonal = LinearLayoutManager(requireContext())
            layoutPersonal.adapter = adapter
        }
    }


    override fun onBackPressedFromInterface(): Boolean {
        return  presenter.onBackPressedInPersonalPresenter()
    }

    override fun onUserNameClick(name: String) {
        //todo открыть персональный экран пользователя
    }

    override fun initList(list: List<ThePerson>) {
        //пока не придумал, что с ней делать
    }

    override fun updateList(list: List<ThePerson>, page: Int) {
        //пока не придумал, что с ней делать
    }


    companion object {
        @JvmStatic
        fun newInstance() = PersonalFragment()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}