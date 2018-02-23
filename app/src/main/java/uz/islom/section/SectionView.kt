package uz.islom.section

import uz.islom.Model.Article as Article

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
    fun stopRefresh()
    fun addDates(data: ArrayList<Article>)

}