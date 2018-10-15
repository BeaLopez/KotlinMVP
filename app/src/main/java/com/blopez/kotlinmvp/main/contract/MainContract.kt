package com.blopez.kotlinmvp.main.contract

/**
 * Created by b.lopez.morales on 21/11/17.
 */
class MainContract {

    interface View {
        fun setTextNumClicks(text: String)
        fun setTextTimer(text: String)
        fun enabledClickMe(enabled: Boolean)
        fun startCountDown()
        fun stopCountDown()
    }

    interface Presenter {
        fun setView(view: View)
        fun eventOnClickMe()
        fun eventOnClickReset()
        fun eventOnTick(millisUntilFinished: Long)
        fun eventOnFinishCountDown()
    }
}