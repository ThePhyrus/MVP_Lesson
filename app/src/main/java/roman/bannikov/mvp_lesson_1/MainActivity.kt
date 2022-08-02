package roman.bannikov.mvp_lesson_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import roman.bannikov.mvp_lesson_1.databinding.ActivityMainBinding

private const val COUNTERS_KEY: String = "counters"

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: CountersPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onCounterClick(R.id.btnOne)
            }
            btnTwo.setOnClickListener {
                presenter.onCounterClick(R.id.btnTwo)
            }
            btnThree.setOnClickListener {
                presenter.onCounterClick(R.id.btnThree)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }


    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от position
    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> {
                    tvCounterOne.text = counter
                }
                1 -> {
                    tvCounterTwo.text = counter
                }
                2 -> {
                    tvCounterThree.text = counter
                }
            }
        }
    }
}