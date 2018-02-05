package uz.islom.main

import java.util.*

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
interface MainPresenter{
    fun onResume()
    fun onItemClick(pos:Int)
    fun onPause()
}