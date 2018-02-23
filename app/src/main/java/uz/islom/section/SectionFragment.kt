package uz.islom.section

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_section.view.*
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.islom.BuildConfig
import uz.islom.Model.Article as Article
import uz.islom.R
import java.io.IOException
import java.util.logging.Level

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/5/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/

class SectionFragment: Fragment(),SectionView{

    private var presenter:SectionPresenter? = null
    private var root:View? = null
    private var adapter: ArticleAdapter? = null
    private var site = 0
    private var section=0

    override fun stopRefresh() {
        root?.swipe?.isRefreshing = false
    }

    override fun addDates(data: ArrayList<Article>) {
        adapter?.addItems(data)
        adapter?.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SectionPresenterImp(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_section, container, false)
        site =arguments.getInt(s,0)
        section = arguments.getInt(c,0)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ArticleAdapter()
        root?.recycler?.layoutManager = LinearLayoutManager(activity)
        root?.recycler?.adapter= adapter
        root?.swipe?.setOnRefreshListener { presenter?.onRefresh() }
                ArticleApiService
                        .create()
                        .getArticles(section.toString(),1.toString())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            result -> addDates(result)
                        }, { error ->
                            error.printStackTrace()
                        })

    }

    companion object {
        private val s = "section"
        private val c = "site"
        fun newInstance(sectionNumber: Int,site : Int): SectionFragment {
            val fragment = SectionFragment()
            val args = Bundle()
            val section = when(sectionNumber){
                0 -> 0
                1 -> 2
                2 -> 5
                3 -> 6
                4 -> 7
                5 -> 8
                6 -> 9
                7 -> 10
                8 -> 11
                9 -> 3
                else -> 0
            }

            args.putInt(s,section)
            args.putInt(c,site)
            fragment.arguments = args
            return fragment
        }
    }
}
