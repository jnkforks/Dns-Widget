package com.sudoajay.dnswidget

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    private lateinit var currentTheme: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         currentTheme = getSharedPreferences("state", Context.MODE_PRIVATE)
            .getString(getString(R.string.dark_mode_text), getString(R.string.off_text)).toString()
        setAppTheme(currentTheme)
    }

    override fun onResume() {
        super.onResume()
        val theme = getSharedPreferences("state", Context.MODE_PRIVATE)
            .getString(getString(R.string.dark_mode_text), getString(R.string.off_text)).toString()
        if (currentTheme != theme)
            recreate()
    }

    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            getString(R.string.off_text) -> setTheme(R.style.AppTheme)
            else -> setTheme(R.style.DarkTheme)
        }
    }
}