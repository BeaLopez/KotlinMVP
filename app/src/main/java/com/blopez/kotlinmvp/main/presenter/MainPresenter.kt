package com.blopez.kotlinmvp.main.presenter

import com.blopez.kotlinmvp.main.contract.MainContract

/**
 * Created by b.lopez.morales on 21/11/17.
 */
open class MainPresenter: MainContract.Presenter{

    private lateinit var mView: MainContract.View
    private var numClicks: Int = 0

    override fun setView(view: MainContract.View) {
        mView = view
    }

    override fun eventOnClickMe() {
        if (numClicks == 0){
            mView.startCountDown()
        }
        numClicks++
        mView.setTextNumClicks(numClicks.toString())
    }

    override fun eventOnClickReset() {
        numClicks = 0
        mView.setTextNumClicks(numClicks.toString())
        mView.setTextTimer("10")
        mView.enabledClickMe(true)
    }

    override fun eventOnTick(millisUntilFinished: Long) {
        mView.setTextTimer((millisUntilFinished / 1000).toString())
    }

    override fun eventOnFinishCountDown() {
        mView.stopCountDown()
        mView.enabledClickMe(false)
    }
}