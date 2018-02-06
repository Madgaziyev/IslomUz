package uz.islom.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

import uz.islom.R

import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_main2.view.*

/**
 * $developer = JavokhirKadirov
 * $project = IslomUz
 * $date = 2/6/18
 * $web_site = https://kadirov.me
 * $email = kadirov.me@gmail.com
 * $github = github.com/javokhirkadirov
 * $linkidin = linkedin.com/in/javokhirkadirov
 **/

class MainFragment : Fragment(){

    private var presenter:MainPresenter? = null
    private var root:View?= null
    private var sectionNumber: Int? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sectionNumber = arguments.getInt(ARG_SECTION_NUMBER)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = if(sectionNumber ==0) inflater.inflate(R.layout.fragment_main, container, false)
        else layoutInflater.inflate(R.layout.fragment_main2, container, false)
        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root?.llIslom?.setOnClickListener { presenter?.onItemClick(0) }
        root?.llIslam?.setOnClickListener { presenter?.onItemClick(1) }
        root?.llQuron?.setOnClickListener { presenter?.onItemClick(2) }
        root?.llHadis?.setOnClickListener { presenter?.onItemClick(3) }
        root?.llFiqh?.setOnClickListener { presenter?.onItemClick(4) }
        root?.llArab?.setOnClickListener { presenter?.onItemClick(5) }
        root?.llMadrasa?.setOnClickListener { presenter?.onItemClick(6) }
        root?.llMasjid?.setOnClickListener { presenter?.onItemClick(7) }
        root?.llSiyrat?.setOnClickListener { presenter?.onItemClick(8) }
        root?.llTarix?.setOnClickListener { presenter?.onItemClick(9) }
        root?.llMuslima?.setOnClickListener { presenter?.onItemClick(10) }
        root?.llSavollar?.setOnClickListener { presenter?.onItemClick(11) }
        root?.llInfo?.setOnClickListener { presenter?.onItemClick(12) }
        root?.llAdabiyot?.setOnClickListener { presenter?.onItemClick(13) }
        root?.llTazkiya?.setOnClickListener { presenter?.onItemClick(14) }
        root?.llTib?.setOnClickListener { presenter?.onItemClick(15) }
        root?.llMedia?.setOnClickListener { presenter?.onItemClick(16) }
    }

    companion object {
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber: Int,presenter: MainPresenter?): MainFragment {
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            val fragment = MainFragment()
            fragment.presenter = presenter
            fragment.arguments = args
            return fragment
        }
    }

}