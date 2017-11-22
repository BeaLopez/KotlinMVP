package com.blopez.kotlinmvp.main.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.blopez.kotlinmvp.R
import com.blopez.kotlinmvp.main.contract.MainContract
import com.blopez.kotlinmvp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    protected lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        my_text_view.text = getString(R.string.hello_world)
    }
}
