package roman.bannikov.mvp_lesson_1.main


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import roman.bannikov.mvp_lesson_1.R
import roman.bannikov.mvp_lesson_1.TheApp
import roman.bannikov.mvp_lesson_1.adapters.UserAdapter
import roman.bannikov.mvp_lesson_1.core.OnBackPressedListener
import roman.bannikov.mvp_lesson_1.databinding.ActivityMainBinding
import roman.bannikov.mvp_lesson_1.model.GithubUser
import roman.bannikov.mvp_lesson_1.repository.implementations.GithubRepositoryImpl


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.containerMain)
    private val presenter by moxyPresenter { MainPresenter(TheApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        TheApp.instance.navHolder.setNavigator(navigator)
    }

    override fun onPause() {
        TheApp.instance.navHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
                if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()) {
                    return
            } else {
                presenter.onBackPressed()
            }
        }
    }
}