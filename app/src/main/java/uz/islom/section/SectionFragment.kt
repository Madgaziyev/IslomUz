package uz.islom.section

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_section.view.*
import uz.islom.R
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

class SectionFragment: Fragment(),SectionView{

    private var presenter:SectionPresenter? = null
    private var root:View? = null

    override fun startRefresh() {

    }

    override fun stopRefresh() {

    }

    override fun addDates(data: ArrayList<Article>) {

    }

    override fun clearData() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SectionPresenterImp(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter?.onCreate()
        root = inflater.inflate(R.layout.fragment_section, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root?.swipe?.setOnRefreshListener { presenter?.onRefresh() }
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int): SectionFragment {
            val fragment = SectionFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}