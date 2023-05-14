package com.example.pathfindergametool

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.pathfindergametool.databinding.FragmentCalcBinding

class Calc() : Fragment() {
    private lateinit var health: String
    private lateinit var safetyHealth: String
    private lateinit var cell1Value:String
    private lateinit var cell2Value:String
    private lateinit var cell3Value:String
    private lateinit var cell4Value:String
    private lateinit var cell5Value:String
    private lateinit var cell6Value:String
    private lateinit var cell7Value:String
    private lateinit var cell8Value:String
    private lateinit var cell9Value:String
    private lateinit var platinumValue: String
    private lateinit var goldValue: String
    private lateinit var silverValue: String
    private lateinit var cuprumValue: String
    private lateinit var otherNotes:String

    private lateinit var currentView: View
    private lateinit var context: Context
    private lateinit  var prefs: SharedPreferences
    private lateinit  var editor:SharedPreferences.Editor
    private var _binding: FragmentCalcBinding? = null
    private val binding get() = _binding!!;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCalcBinding.inflate(inflater, container, false)
        currentView = binding.root


        initValues()
        textChangeListner()
        buttonClickListners()
        updateText()
        return currentView
    }


    override fun onAttach(_context: Context) {
        super.onAttach(_context)

        context = _context
        prefs = context.getSharedPreferences("Health", Context.MODE_PRIVATE)
        editor = prefs.edit()
    }

    override fun onPause() {
        editor.putString("health", health)
        editor.putString("safetyHealth", safetyHealth)
        editor.putString("cell1value", cell1Value)
        editor.putString("cell2value", cell2Value)
        editor.putString("cell3value", cell3Value)
        editor.putString("cell4value", cell4Value)
        editor.putString("cell5value", cell5Value)
        editor.putString("cell6value", cell6Value)
        editor.putString("cell7value", cell7Value)
        editor.putString("cell8value", cell8Value)
        editor.putString("cell9value", cell9Value)
        editor.putString("platinumValue", platinumValue)
        editor.putString("goldValue", goldValue)
        editor.putString("silverValue", silverValue)
        editor.putString("cuprumValue", cuprumValue)
        editor.putString("otherNotes", otherNotes)
        editor.commit()

        super.onPause()
    }


    private fun updateText(){
        binding.hitTextView.setText(health)
        binding.hitTextView2.setText(safetyHealth)
        binding.cell1Value.setText(cell1Value)
        binding.cell2Value.setText(cell2Value)
        binding.cell3Value.setText(cell3Value)
        binding.cell4Value.setText(cell4Value)
        binding.cell5Value.setText(cell5Value)
        binding.cell6Value.setText(cell6Value)
        binding.cell7Value.setText(cell7Value)
        binding.cell8Value.setText(cell8Value)
        binding.cell9Value.setText(cell9Value)
        binding.platinumValue.setText(platinumValue)
        binding.goldValue.setText(goldValue)
        binding.silverValue.setText(silverValue)
        binding.cuprumValue.setText(cuprumValue)
        binding.otherNotes.setText(otherNotes)
    }

    private fun initValues(){
        health = prefs.getString("health","0").toString()
        safetyHealth = prefs.getString("safetyHealth","0").toString()
        cell1Value = prefs.getString("cell1value","0").toString()
        cell2Value = prefs.getString("cell2value","0").toString()
        cell3Value = prefs.getString("cell3value","0").toString()
        cell4Value = prefs.getString("cell4value","0").toString()
        cell5Value = prefs.getString("cell5value","0").toString()
        cell6Value = prefs.getString("cell6value","0").toString()
        cell7Value = prefs.getString("cell7value","0").toString()
        cell8Value = prefs.getString("cell8value","0").toString()
        cell9Value = prefs.getString("cell9value","0").toString()
        platinumValue = prefs.getString("platinumValue","0").toString()
        goldValue = prefs.getString("goldValue","0").toString()
        silverValue = prefs.getString("silverValue","0").toString()
        cuprumValue = prefs.getString("cuprumValue","0").toString()
        otherNotes = prefs.getString("otherNotes","").toString()
    }

    private fun textChangeListner(){
        binding.hitTextView.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) { health = binding.hitTextView.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.hitTextView2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { safetyHealth = binding.hitTextView2.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell1Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell1Value = binding.cell1Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell2Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell2Value = binding.cell2Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell3Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell3Value = binding.cell3Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell4Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell4Value = binding.cell4Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell5Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell5Value = binding.cell5Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell6Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell6Value = binding.cell6Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell7Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell7Value = binding.cell7Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell8Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell8Value = binding.cell8Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cell9Value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cell9Value = binding.cell9Value.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.platinumValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { platinumValue = binding.platinumValue.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.goldValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { goldValue = binding.goldValue.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.silverValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { silverValue = binding.silverValue.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        binding.cuprumValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { cuprumValue = binding.cuprumValue.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        binding.otherNotes.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { otherNotes = binding.otherNotes.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun buttonClickListners(){
        binding.plus5Button.setOnClickListener{binding.hitTextView.setText(calcHP(health, 5))}
        binding.plus1Button.setOnClickListener{binding.hitTextView.setText(calcHP(health, 1))}
        binding.minus1Button.setOnClickListener{binding.hitTextView.setText(calcHP(health, -1))}
        binding.minus5Button.setOnClickListener{binding.hitTextView.setText(calcHP(health, -5))}

        binding.plus5Button2.setOnClickListener{binding.hitTextView2.setText(calcHP(safetyHealth, 5))}
        binding.plus1Button2.setOnClickListener{binding.hitTextView2.setText(calcHP(safetyHealth, 1))}
        binding.minus1Button2.setOnClickListener{binding.hitTextView2.setText(calcHP(safetyHealth, -1))}
        binding.minus5Button2.setOnClickListener{binding.hitTextView2.setText(calcHP(safetyHealth, -5))}

        binding.cell1Plus.setOnClickListener{binding.cell1Value.setText(calcHP(cell1Value, 1, true))}
        binding.cell2Plus.setOnClickListener{binding.cell2Value.setText(calcHP(cell2Value, 1, true))}
        binding.cell3Plus.setOnClickListener{binding.cell3Value.setText(calcHP(cell3Value, 1, true))}
        binding.cell4Plus.setOnClickListener{binding.cell4Value.setText(calcHP(cell4Value, 1, true))}
        binding.cell5Plus.setOnClickListener{binding.cell5Value.setText(calcHP(cell5Value, 1, true))}
        binding.cell6Plus.setOnClickListener{binding.cell6Value.setText(calcHP(cell6Value, 1, true))}
        binding.cell7Plus.setOnClickListener{binding.cell7Value.setText(calcHP(cell7Value, 1, true))}
        binding.cell8Plus.setOnClickListener{binding.cell8Value.setText(calcHP(cell8Value, 1, true))}
        binding.cell9Plus.setOnClickListener{binding.cell9Value.setText(calcHP(cell9Value, 1, true))}

        binding.cell1Minus.setOnClickListener{binding.cell1Value.setText(calcHP(cell1Value, -1, true))}
        binding.cell2Minus.setOnClickListener{binding.cell2Value.setText(calcHP(cell2Value, -1, true))}
        binding.cell3Minus.setOnClickListener{binding.cell3Value.setText(calcHP(cell3Value, -1, true))}
        binding.cell4Minus.setOnClickListener{binding.cell4Value.setText(calcHP(cell4Value, -1, true))}
        binding.cell5Minus.setOnClickListener{binding.cell5Value.setText(calcHP(cell5Value, -1, true))}
        binding.cell6Minus.setOnClickListener{binding.cell6Value.setText(calcHP(cell6Value, -1, true))}
        binding.cell7Minus.setOnClickListener{binding.cell7Value.setText(calcHP(cell7Value, -1, true))}
        binding.cell8Minus.setOnClickListener{binding.cell8Value.setText(calcHP(cell8Value, -1, true))}
        binding.cell9Minus.setOnClickListener{binding.cell9Value.setText(calcHP(cell9Value, -1, true))}
    }

    private fun calcHP(value: String, iter:Int, isCell : Boolean = false) : String{
        if(value == "" || value == null)  return "0"
        var currentNumericValue: Int

        try {
            currentNumericValue = value.toInt()
        }catch (e:NumberFormatException){return "0"}


        if(isCell && currentNumericValue + iter > 99) return "99"
        else if(isCell && currentNumericValue + iter < 0) return "0"
        else if (currentNumericValue + iter > 99999) return "99999"
        else if(currentNumericValue + iter < -9999) return "-9999"

        return (currentNumericValue + iter).toString()
    }
}