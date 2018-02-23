package uz.islom.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
class MainPresenterImp (private var view : MainView): MainPresenter {

    override fun onResume() {
        view.registerListener(receiver, IntentFilter(Intent.ACTION_DATE_CHANGED))
        view.startAnimate()
    }

    override fun onItemClick(pos: Int) {
        when(pos){
            in 0..16 -> view.goSectionActivity(pos)
            17 -> view.goNamozActivity()
            18 -> view.goRadioActivity()
            19 -> view.goQiblaActivity()
            20 -> view.goRamazonActivity()
        }
    }

    override fun onPause() {
        view.unregisterListener(receiver)
        view.stopAnimate()
    }

    private var receiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // convert gregorian to hijri
            view.dateChanged("","")
        }
    }
}