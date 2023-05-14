package com.example.pathfindergametool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pathfindergametool.databinding.FragmentCalcBinding
import com.example.pathfindergametool.databinding.FragmentLibrarySpellsBinding
import com.google.gson.Gson
import java.io.FileInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception

class LibrarySpells : Fragment() {

    private var _binding: FragmentLibrarySpellsBinding? = null
    private val binding get() = _binding!!;
    private lateinit var currentView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLibrarySpellsBinding.inflate(inflater, container, false)
        currentView = binding.root
        return currentView
    }
    
}