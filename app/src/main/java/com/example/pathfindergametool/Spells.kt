package com.example.pathfindergametool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.util.Calendar

class Spells : Fragment(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var currentView:View
    private lateinit var spellsNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentView = inflater.inflate(R.layout.fragment_spells, container, false)

        spellsNavigationView = currentView.findViewById(R.id.spellsNavigationView)
        if(spellsNavigationView != null){
            spellsNavigationView.setOnItemSelectedListener (this::onNavigationItemSelected)
            CommitFragment(FavoritesSpelss())
        }

        return currentView
    }

    override fun onNavigationItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.FavoriteFrame -> CommitFragment(FavoritesSpelss())
            R.id.LibraryFrame -> CommitFragment(LibrarySpells())
        }
        return true
    }

    fun CommitFragment(fragment:Fragment){

        var fragmentTransaction: FragmentTransaction? = childFragmentManager.beginTransaction()
        if(fragmentTransaction != null && fragment != null){
            var fragments: List<Fragment>  = childFragmentManager.fragments

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

            fragmentTransaction.add(R.id.spellsFrameContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}