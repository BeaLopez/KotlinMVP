package com.blopez.kotlinmvp.main.contract

/**
 * Created by b.lopez.morales on 21/11/17.
 */
class MainContract{

    interface View{
        fun setText(text: String)
    }

    interface Presenter{
        fun setView(view: View)
        fun eventOnClickMe()
        fun eventOnClickReset()
    }
}