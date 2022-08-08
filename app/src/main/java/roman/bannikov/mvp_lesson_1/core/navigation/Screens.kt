package roman.bannikov.mvp_lesson_1.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import roman.bannikov.mvp_lesson_1.personal.PersonalFragment
import roman.bannikov.mvp_lesson_1.user.UserFragment

object UsersScreens : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

object PersonalScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return PersonalFragment.newInstance()
    }

}