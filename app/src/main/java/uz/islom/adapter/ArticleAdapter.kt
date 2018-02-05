package uz.islom.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import uz.islom.R
import uz.islom.model.Article
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

    private var items: ArrayList<Article>? = null
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    init {
        items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_article, parent, false)
            return ItemViewHolder(view)
        } else if (viewType == VIEW_TYPE_LOADING) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_loading, parent, false)
            return LoadingViewHolder(view)
        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val article = items!![position]
          //  holder.bindArticle(article)
        } else if (holder is LoadingViewHolder) {
            holder.progressBar.isIndeterminate = true
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items!!.size == position) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return items!!.size + 1
    }

    fun addItems(items: ArrayList<Article>) {
        this.items!!.addAll(items)
    }

    fun updateItems(items: ArrayList<Article>?) {
        this.items=items
    }


    private inner class LoadingViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var progressBar: ProgressBar = view.findViewById(R.id.adapter_progress)
    }


    internal class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {


        var context: Context = v.context
        var titleView: TextView = v.findViewById(R.id.article_title)
        var dateView: TextView =v.findViewById(R.id.article_date)
        var hitView: TextView = v.findViewById(R.id.article_hit)
        var imageView: ImageView = v.findViewById(R.id.article_image)
        var id: String = "1"

        init {
            v.setOnClickListener(this)
        }

        fun bindArticle(article: Article.ArticleRes) {
            id = article.id
            titleView.text = article.title
            dateView.text = article.time
            hitView.text = article.hits

        //    Picasso.with(context).load(article.imageUrl).fit().into(imageView)
        }

        override fun onClick(v: View) {

        }
    }


}
