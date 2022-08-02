package roman.bannikov.mvp_lesson_1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import roman.bannikov.mvp_lesson_1.databinding.ActivityMainBinding


const val POS_ONE: Int = 0
const val POS_TWO: Int = 1
const val POS_THREE: Int = 2

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

/*        with(binding) {
            btnOne.setOnClickListener {
                presenter.onClickCounterOne(R.id.btnOne)
            }
            btnTwo.setOnClickListener {
                presenter.onCounterClick(R.id.btnTwo)
            }
            btnThree.setOnClickListener {
                presenter.onCounterClick(R.id.btnThree)
            }
        }*/

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onClickCounterOne(POS_ONE)
            }
            btnTwo.setOnClickListener {
                presenter.onClickCounterTwo(POS_TWO)
            }
            btnThree.setOnClickListener {
                presenter.onClickCounterThree(POS_THREE)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }


    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от position
    //FIXME даже с подсказкой не понял(( Растолкуйте, что к чему, пожалуйста.
    override fun setCounterText(text: String, position: Int) {

/*        with(binding) {
            when (position) {
                0 -> {
                    tvCounterOne.text = text
                }
                1 -> {
                    tvCounterTwo.text = text
                }
                2 -> {
                    tvCounterThree.text = text
                }
            }
        }*/

        with(binding) {
            when (position) {
                POS_ONE -> {
                    tvCounterOne.text = text
                }
                POS_TWO -> {
                    tvCounterTwo.text = text
                }
                POS_THREE -> {
                    tvCounterThree.text = text
                }
            }
        }
    }
}