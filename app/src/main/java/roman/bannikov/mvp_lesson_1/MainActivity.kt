package roman.bannikov.mvp_lesson_1


import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import roman.bannikov.mvp_lesson_1.databinding.ActivityMainBinding


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { CountersPresenter(CountersModel()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onClickCounterOne()
            }
            btnTwo.setOnClickListener {
                presenter.onClickCounterTwo()
            }
            btnThree.setOnClickListener {
                presenter.onClickCounterThree()
            }
        }
    }


    override fun setTextOnCounterOne(counter: String) = with(binding) {
        tvCounterOne.text = counter
    }

    override fun setTextOnCounterTwo(counter: String) = with(binding) {
        tvCounterTwo.text = counter
    }

    override fun setTextOnCounterThree(counter: String) = with(binding) {
        tvCounterThree.text = counter
    }


}