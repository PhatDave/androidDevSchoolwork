package hr.suka.lv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backButton = findViewById<Button>(R.id.activity2ReturnButton)
        val fragmentButton = findViewById<Button>(R.id.activity2FragmentButton)

        var currentFragment = 0;
        val fragmentMap = HashMap<Int, Fragment>()
        fragmentMap[0] = ItemFragment.newInstance(2)
        fragmentMap[1] = BlankFragment.newInstance("Fragment 2", "Fragment 2")
        fragmentMap[2] = BlankFragment2.newInstance("Fragment 3", "Fragment 3")

        fragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, fragmentMap[currentFragment]!!)
                .commit()
            currentFragment++
            if (currentFragment > 2) {
                currentFragment = 0
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}