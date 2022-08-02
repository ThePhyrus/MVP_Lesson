package roman.bannikov.mvp_lesson_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import roman.bannikov.mvp_lesson_1.databinding.ActivityMainBinding

private const val COUNTERS_KEY: String = "counters"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        with(binding) {
            btnOne.setOnClickListener {
                tvCounterOne.text = (++counters[0]).toString()
            }
            btnTwo.setOnClickListener {
                tvCounterTwo.text = (++counters[1]).toString()
            }
            btnThree.setOnClickListener {
                tvCounterThree.text = (++counters[2]).toString()
            }
        }
    }

    private fun initViews() {
        with(binding) {
            tvCounterOne.text = counters[0].toString()
            tvCounterTwo.text = counters[1].toString()
            tvCounterThree.text = counters[2].toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(COUNTERS_KEY, counters.toIntArray())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray(COUNTERS_KEY)
        counters.let { list ->
            array?.toList()?.let {
                list.addAll(it)
            }
        }
        initViews()
    }
}