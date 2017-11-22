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
        numClicks++
        mView.setText(numClicks.toString())
    }

    override fun eventOnClickReset() {
        numClicks = 0
        mView.setText(numClicks.toString())
    }
}