package uz.islom.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_splash.*
import uz.islom.R
import uz.islom.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        image.startAnimation(getAnimation())

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },2000)
    }

    private fun getAnimation(): Animation {
        val animation = ScaleAnimation(1f,1.1f,1f,1.1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        animation.duration=700
        animation.repeatCount= Animation.INFINITE
        animation.repeatMode = Animation.REVERSE
        return  animation
    }


}
