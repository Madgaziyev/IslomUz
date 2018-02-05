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
        view.goSectionActivity(if(pos in 0..16) pos else 0)
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