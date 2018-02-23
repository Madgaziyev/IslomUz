package uz.islom.section

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import uz.islom.Model.Article as Article
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/
interface ArticleApiService {

    @GET("api/news")
    fun getArticles(@Query("section") section: String,
                      @Query("page") page: String) : Observable<ArrayList<Article>>

    companion object Factory{
        fun create(): ArticleApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://islom.uz/")
                    .build()

            return retrofit.create<ArticleApiService>(ArticleApiService::class.java)
        }
    }

}