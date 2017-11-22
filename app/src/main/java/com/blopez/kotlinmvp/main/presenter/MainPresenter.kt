package com.blopez.kotlinmvp.main.presenter

import com.blopez.kotlinmvp.main.contract.MainContract

/**
 * Created by b.lopez.morales on 21/11/17.
 */
class MainPresenter: MainContract.Presenter{

    protected lateinit var mView: MainContract.View

    override fun setView(view: MainContract.View) {
        mView = view
    }
}