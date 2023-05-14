package com.example.pathfindergametool

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.pathfindergametool.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var GlobalMenuButton:AppCompatImageButton
    private lateinit var mainContainer: DrawerLayout
    private lateinit var globalNavigationView: NavigationView

    companion object{
        @JvmStatic lateinit var mainContext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TopBarSetup()
        mainContext = this
    }

    override fun onResume() {
        super.onResume()
    }

    private fun TopBarSetup(){
        GlobalMenuButton = findViewById(R.id.globalMenuButton)
        mainContainer = findViewById(R.id.mainContainer)
        globalNavigationView = findViewById(R.id.globalNavigationView)
        if(globalNavigationView != null){
            globalNavigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected)
            CommitFragment(Calc())
        }

        GlobalMenuButton.setOnClickListener{
            mainContainer.openDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.calculatorFrame -> CommitFragment(Calc())
            R.id.spellsFrame -> CommitFragment(Spells())
        }
        return true
    }

    fun CommitFragment(fragment:Fragment){
        if(mainContainer != null) mainContainer.closeDrawer(GravityCompat.START)

        var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if(fragmentTransaction != null && fragment != null){
            var fragments: List<Fragment>  = supportFragmentManager.fragments

            for(itemFragment in fragments){
                if(itemFragment.javaClass.simpleName != fragment.javaClass.simpleName){
                    fragmentTransaction.hide(itemFragment)
                }
            }

            if(fragment.isAdded){
                fragmentTransaction.show(fragment)
                fragmentTransaction.commit()
                return
            }

            for(itemFragment in fragments){
                if(itemFragment.javaClass.simpleName == fragment.javaClass.simpleName){
                    fragmentTransaction.show(itemFragment)
                    fragmentTransaction.commit()
                    return
                }
            }

            fragmentTransaction.add(R.id.globalFrameContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}