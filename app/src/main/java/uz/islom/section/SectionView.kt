package uz.islom.section

import uz.islom.model.Article

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
interface SectionView{
    fun startRefresh()
    fun stopRefresh()
    fun addDates(data: ArrayList<Article>)
    fun clearData()
}