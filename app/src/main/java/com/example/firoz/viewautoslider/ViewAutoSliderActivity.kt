package com.example.firoz.viewautoslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.ViewFlipper

class ViewAutoSliderActivity : AppCompatActivity() {

    /*ViewFlipper is a subclass of ViewAnimator which is used for switching between views.
   * ViewFlipper and ViewSwitcher both are sub classes of ViewAnimator and does the same task.
   * The main difference between the two is ViewSwitcher can hold only two child views but
   * ViewFlipper can holds two or more child views and show one at a time.
   *
   * */
    private lateinit var viewFlipper: ViewFlipper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_auto_slider)
        viewFlipper = findViewById(R.id.view_flipper)
        val textView = TextView(this)
        textView.text = "Dynamically added TextView"
        textView.gravity = Gravity.CENTER
        viewFlipper.addView(textView)

        viewFlipper.setFlipInterval(1000)
        viewFlipper.startFlipping()
    }

    fun previousView(v: View) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right)
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left)
        viewFlipper.showPrevious()
    }

    fun nextView(v: View) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left)
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right)
        viewFlipper.showNext()
    }
}
