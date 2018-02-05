package uz.islom.model

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
class Article(private var articles : ArrayList<ArticleRes>){


    data class ArticleRes(val id:String,val title:String,val imageUrl:String,val hits:String,val time:String)
}

