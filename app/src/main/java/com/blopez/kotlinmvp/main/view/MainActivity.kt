package com.blopez.kotlinmvp.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.blopez.kotlinmvp.R
import com.blopez.kotlinmvp.main.contract.MainContract
import com.blopez.kotlinmvp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mPresenter: MainPresenter
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        initTimer()
        addButtonListeners()
    }

    private fun initPresenter(){
        mPresenter = MainPresenter()
        mPresenter.setView(this)
    }

    private fun initTimer(){

        countDownTimer = object: CountDownTimer(10000, 1000){
            override fun onFinish() {
                mPresenter.eventOnFinishCountDown()
            }

            override fun onTick(millisUntilFinished: Long) {
                mPresenter.eventOnTick(millisUntilFinished)
            }
        }
    }

    private fun addButtonListeners(){
        btn_click_me.setOnClickListener { mPresenter.eventOnClickMe() }
        btn_reset.setOnClickListener { mPresenter.eventOnClickReset() }
    }

    override fun enabledClickMe(enabled: Boolean) {
        btn_click_me.isEnabled = enabled
    }

    override fun setTextNumClicks(text: String) {
        tv_num_clicks.text = getString(R.string.clicks) + " $text"
    }

    override fun setTextTimer(text: String) {
        tv_timer.text = ": $text"
    }

    override fun startCountDown() {
        countDownTimer.start()
    }

    override fun stopCountDown() {
       countDownTimer.cancel()
    }
}
