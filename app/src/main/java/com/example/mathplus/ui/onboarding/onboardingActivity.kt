package com.example.mathplus.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mathplus.R
import com.example.mathplus.ui.MainActivity
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class onboardingActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(
            AppIntroFragment.createInstance(
            title = "The title of your slide",
            description = "A description that will be shown on the bottom",
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = androidx.transition.R.color.accent_material_light
        ))

        addSlide(
            AppIntroFragment.createInstance(
                title = "The title of your slide",
                description = "A description that will be shown on the bottom",
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = androidx.transition.R.color.accent_material_light
            ))

        addSlide(
            AppIntroFragment.createInstance(
                title = "The title of your slide",
                description = "A description that will be shown on the bottom",
                titleColorRes = R.color.black,
                descriptionColorRes = R.color.black,
                backgroundColorRes = androidx.transition.R.color.accent_material_light
            ))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        startActivity(Intent(this, MainActivity::class.java))

        finish()
    }
}