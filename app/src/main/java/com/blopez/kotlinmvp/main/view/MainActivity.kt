package com.blopez.kotlinmvp.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.blopez.kotlinmvp.R
import com.blopez.kotlinmvp.main.contract.MainContract
import com.blopez.kotlinmvp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        addButtonListeners()
    }

    private fun initPresenter(){
        mPresenter = MainPresenter()
        mPresenter.setView(this)
    }

    private fun addButtonListeners(){
        btn_click_me.setOnClickListener { mPresenter.eventOnClickMe() }
        btn_reset.setOnClickListener { mPresenter.eventOnClickReset() }
    }

    override fun setText(text: String) {
        tv_num_clicks.text = getString(R.string.clicks) + " $text"
    }
}
