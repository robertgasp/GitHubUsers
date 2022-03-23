package com.example.githubusers.view.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubusers.R
import com.example.githubusers.databinding.ActivityDetailsBinding
import com.example.githubusers.presenter.details.DetailsPresenter
import com.example.githubusers.presenter.details.PresenterDetailsContract
import java.util.*

class DetailsActivity : AppCompatActivity(), ViewDetailsContract {

//    private val presenter: PresenterDetailsContract = DetailsPresenter(this)
    private val presenter: PresenterDetailsContract = DetailsPresenter(0)
    private lateinit var binding:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.onAttach(this)
        setUI()
    }

    private fun setUI() {
        val count = intent.getIntExtra(TOTAL_COUNT_EXTRA, 0)
        presenter.setCounter(count)
        setCountText(count)
        binding.decrementButton.setOnClickListener { presenter.onDecrement() }
        binding.incrementButton.setOnClickListener { presenter.onIncrement() }
    }

    override fun setCount(count: Int) {
        setCountText(count)
    }

    private fun setCountText(count: Int) {
        binding.totalCountTextView.text =
            String.format(Locale.getDefault(), getString(R.string.results_count), count)
    }

    override fun onDestroy() {
        presenter.onDetach(this)
        super.onDestroy()
    }

    companion object {

        const val TOTAL_COUNT_EXTRA = "TOTAL_COUNT_EXTRA"

        fun getIntent(context: Context, totalCount: Int): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(TOTAL_COUNT_EXTRA, totalCount)
            }
        }
    }
}