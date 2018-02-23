package uz.islom.section

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import uz.islom.Model
import uz.islom.R
import java.util.ArrayList

/**
 * $developer = JavokhirKadirov
 * $project = IslomUzPortal
 * $date = 2/1/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/

class ArticleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<Model.Article>? = null

    private val typeLoading = 0
    private val typeHeader = 1
    private val typeSimple = 2

    init {
        items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            typeLoading -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
                return LoadingViewHolder(view)
            }
            typeSimple -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
                return SimpleViewHolder(view)
            }
            typeHeader -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(view)
            }
        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SimpleViewHolder ->{
                val article = items!![position]
                holder.bindArticle(article)
            }
            is HeaderViewHolder ->{
                val article = items!![position]
                holder.bindArticle(article)
            }

            is LoadingViewHolder ->{
                holder.progressBar.isIndeterminate = true
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (items!!.size == position) typeLoading  else if(position ==  0)  typeHeader else typeSimple
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return items!!.size + 1
    }

    fun addItems(items: ArrayList<Model.Article>) {
        this.items!!.addAll(items)
    }

    fun updateItems(items: ArrayList<Model.Article>?) {
        this.items=items
    }

    private inner class LoadingViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var progressBar: ProgressBar = view.findViewById(R.id.adapter_progress)
    }

    private inner class HeaderViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var context: Context = v.context
        var titleView: TextView = v.findViewById(R.id.article_title)
        var dateView: TextView =v.findViewById(R.id.article_date)
        var hitView: TextView = v.findViewById(R.id.article_hit)
        var imageView: ImageView = v.findViewById(R.id.article_image)
        var id: String = "1"


        fun bindArticle(article: Model.Article) {
            id = article.id
            titleView.text = article.title
            dateView.text = article.created_at
            hitView.text = article.hits
            Picasso.with(context).load("https://islom.uz/images/section/"+article.image_name).fit().into(imageView)
        }
    }


    private inner class SimpleViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var context: Context = v.context
        var titleView: TextView = v.findViewById(R.id.article_title)
        var dateView: TextView =v.findViewById(R.id.article_date)
        var hitView: TextView = v.findViewById(R.id.article_hit)
        var imageView: ImageView = v.findViewById(R.id.article_image)
        var id: String = "1"

        fun bindArticle(article: Model.Article) {
            id = article.id
            titleView.text = article.title
            dateView.text = article.created_at
            hitView.text = article.hits
            Picasso.with(context).load("https://islom.uz/images/section/"+article.image_name).centerCrop().into(imageView)
        }
    }


}
