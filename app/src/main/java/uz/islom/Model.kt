package uz.islom

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/6/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
class Model{
    data class Article(val id:String,val title:String,val image_name:String,val hits:String,val created_at:String)
}