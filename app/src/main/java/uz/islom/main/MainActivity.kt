package uz.islom.main

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import uz.islom.R
import uz.islom.section.SectionActivity

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main)

        presenter = MainPresenterImp(this)

        ivNamoz.setOnClickListener { presenter?.onItemClick(17) }
        ivRadio.setOnClickListener { presenter?.onItemClick(18) }
        ivQibla.setOnClickListener { presenter?.onItemClick(19) }
        ivRamazon.setOnClickListener { presenter?.onItemClick(20) }
        vpContent.adapter = SectionsPagerAdapter(supportFragmentManager)
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        presenter?.onPause()
        super.onPause()
    }

    override fun registerListener(receiver: BroadcastReceiver, filter: IntentFilter) {
        registerReceiver(receiver, filter)
    }

    override fun unregisterListener(receiver: BroadcastReceiver) {
        unregisterReceiver(receiver)
    }

    override fun startAnimate() {
        ivNamoz.startAnimation(getAnimation())
        ivRadio.startAnimation(getAnimation())
        ivQibla.startAnimation(getAnimation())
        ivRamazon.startAnimation(getAnimation())
    }

    override fun stopAnimate() {
        ivNamoz.clearAnimation()
        ivRadio.clearAnimation()
        ivQibla.clearAnimation()
        ivRamazon.clearAnimation()
    }

    override fun goSectionActivity(site: Int) {
        startActivity(Intent(this, SectionActivity::class.java).putExtra("site", site))
    }

    override fun goNamozActivity() {

    }

    override fun goRadioActivity() {

    }

    override fun goQiblaActivity() {

    }

    override fun goRamazonActivity() {

    }

    override fun currentTimeChanged(pos: Int) {
        (llBomdod.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llBomdod.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llQuyosh.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llQuyosh.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llPeshin.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llPeshin.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llAsr.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llAsr.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llShom.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llShom.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llXufton.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainText))
        (llXufton.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainText))

        when (pos) {
            0 -> {
                (llBomdod.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llBomdod.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
            1 -> {
                (llQuyosh.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llQuyosh.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
            2 -> {
                (llPeshin.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llPeshin.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
            3 -> {
                (llAsr.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llAsr.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
            4 -> {
                (llShom.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llShom.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
            5 -> {
                (llXufton.getChildAt(0) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
                (llXufton.getChildAt(1) as TextView).setTextColor(resources.getColor(R.color.cMainTextPrayTime))
            }
        }
    }

    override fun dateChanged(gregorian: String, hijri: String) {
        tvGregorian.text = gregorian
        tvHijri.text = hijri
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return MainFragment.newInstance(position,presenter)
        }

        override fun getCount(): Int {
            return 2
        }
    }

    private fun getAnimation(): RotateAnimation {
        val animation = RotateAnimation(-3F, 3F, 0f, 0f)
        animation.duration = 3000
        animation.repeatCount = Animation.INFINITE
        animation.repeatMode = Animation.REVERSE
        return animation
    }
}
