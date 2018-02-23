package uz.islom.main

import android.content.BroadcastReceiver
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
interface MainView{

    fun registerListener(receiver: BroadcastReceiver,filter: IntentFilter)
    fun unregisterListener( receiver: BroadcastReceiver)

    fun startAnimate()
    fun stopAnimate()

    fun currentTimeChanged(pos : Int)
    fun dateChanged(gregorian : String, hijri: String)

    fun goSectionActivity(site:Int)
    fun goNamozActivity()
    fun goRadioActivity()
    fun goQiblaActivity()
    fun goRamazonActivity()

}