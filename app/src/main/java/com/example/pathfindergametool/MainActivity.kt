package com.example.pathfindergametool

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.pathfindergametool.R

class MainActivity : AppCompatActivity() {

    private lateinit var health: String
    private lateinit var safetyHealth: String
    private lateinit var healthTextBox: EditText
    private lateinit var minus1button: Button
    private lateinit var minus5button: Button
    private lateinit var plus1button: Button
    private lateinit var plus5button: Button
    private lateinit var healthTextBox2: EditText
    private lateinit var minus1button2: Button
    private lateinit var minus5button2: Button
    private lateinit var plus1button2: Button
    private lateinit var plus5button2: Button

    private lateinit var cell1PlusButton: Button
    private lateinit var cell2PlusButton: Button
    private lateinit var cell3PlusButton: Button
    private lateinit var cell4PlusButton: Button
    private lateinit var cell5PlusButton: Button
    private lateinit var cell6PlusButton: Button
    private lateinit var cell7PlusButton: Button
    private lateinit var cell8PlusButton: Button
    private lateinit var cell9PlusButton: Button

    private lateinit var cell1MinusButton: Button
    private lateinit var cell2MinusButton: Button
    private lateinit var cell3MinusButton: Button
    private lateinit var cell4MinusButton: Button
    private lateinit var cell5MinusButton: Button
    private lateinit var cell6MinusButton: Button
    private lateinit var cell7MinusButton: Button
    private lateinit var cell8MinusButton: Button
    private lateinit var cell9MinusButton: Button

    private lateinit var cell1ValueTextBox: EditText
    private lateinit var cell2ValueTextBox: EditText
    private lateinit var cell3ValueTextBox: EditText
    private lateinit var cell4ValueTextBox: EditText
    private lateinit var cell5ValueTextBox: EditText
    private lateinit var cell6ValueTextBox: EditText
    private lateinit var cell7ValueTextBox: EditText
    private lateinit var cell8ValueTextBox: EditText
    private lateinit var cell9ValueTextBox: EditText

    private lateinit var cell1Value:String
    private lateinit var cell2Value:String
    private lateinit var cell3Value:String
    private lateinit var cell4Value:String
    private lateinit var cell5Value:String
    private lateinit var cell6Value:String
    private lateinit var cell7Value:String
    private lateinit var cell8Value:String
    private lateinit var cell9Value:String

    private lateinit var platinumValueTextBox:EditText
    private lateinit var goldValueTextBox:EditText
    private lateinit var silverValueTextBox:EditText
    private lateinit var cuprumValueTextBox:EditText

    private lateinit var platinumValue: String
    private lateinit var goldValue: String
    private lateinit var silverValue: String
    private lateinit var cuprumValue: String

    private lateinit var otherNotesTextBox: EditText
    private lateinit var otherNotes:String

    override fun onPause() {
        val sharedPreference = getSharedPreferences("Health", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initValues()
        initViews()
        textChangeListner()
        buttonClickListners()
        updateText()

    }

    override fun onResume() {
        super.onResume()
    }

    private fun updateText(){
        healthTextBox.setText(health)
        healthTextBox2.setText(safetyHealth)
        cell1ValueTextBox.setText(cell1Value)
        cell2ValueTextBox.setText(cell2Value)
        cell3ValueTextBox.setText(cell3Value)
        cell4ValueTextBox.setText(cell4Value)
        cell5ValueTextBox.setText(cell5Value)
        cell6ValueTextBox.setText(cell6Value)
        cell7ValueTextBox.setText(cell7Value)
        cell8ValueTextBox.setText(cell8Value)
        cell9ValueTextBox.setText(cell9Value)

        platinumValueTextBox.setText(platinumValue)
        goldValueTextBox.setText(goldValue)
        silverValueTextBox.setText(silverValue)
        cuprumValueTextBox.setText(cuprumValue)
        otherNotesTextBox.setText(otherNotes)
    }

    private fun initValues(){

        val sharedPreference = getSharedPreferences("Health", Context.MODE_PRIVATE)
        health = sharedPreference.getString("health","0").toString()
        safetyHealth = sharedPreference.getString("safetyHealth","0").toString()
        cell1Value = sharedPreference.getString("cell1value","0").toString()
        cell2Value = sharedPreference.getString("cell2value","0").toString()
        cell3Value = sharedPreference.getString("cell3value","0").toString()
        cell4Value = sharedPreference.getString("cell4value","0").toString()
        cell5Value = sharedPreference.getString("cell5value","0").toString()
        cell6Value = sharedPreference.getString("cell6value","0").toString()
        cell7Value = sharedPreference.getString("cell7value","0").toString()
        cell8Value = sharedPreference.getString("cell8value","0").toString()
        cell9Value = sharedPreference.getString("cell9value","0").toString()
        platinumValue = sharedPreference.getString("platinumValue","0").toString()
        goldValue = sharedPreference.getString("goldValue","0").toString()
        silverValue = sharedPreference.getString("silverValue","0").toString()
        cuprumValue = sharedPreference.getString("cuprumValue","0").toString()
        otherNotes = sharedPreference.getString("otherNotes","").toString()
    }

    private fun initViews(){
        healthTextBox = findViewById(R.id.hitTextView)
        minus1button = findViewById(R.id.minus1_button)
        minus5button = findViewById(R.id.minus5_button)
        plus1button = findViewById(R.id.plus1_button)
        plus5button = findViewById(R.id.plus5_button)
        healthTextBox2 = findViewById(R.id.hitTextView2)
        minus1button2 = findViewById(R.id.minus1_button2)
        minus5button2 = findViewById(R.id.minus5_button2)
        plus1button2 = findViewById(R.id.plus1_button2)
        plus5button2 = findViewById(R.id.plus5_button2)
        cell1MinusButton = findViewById(R.id.cell1Minus)
        cell2MinusButton = findViewById(R.id.cell2Minus)
        cell3MinusButton = findViewById(R.id.cell3Minus)
        cell4MinusButton = findViewById(R.id.cell4Minus)
        cell5MinusButton = findViewById(R.id.cell5Minus)
        cell6MinusButton = findViewById(R.id.cell6Minus)
        cell7MinusButton = findViewById(R.id.cell7Minus)
        cell8MinusButton = findViewById(R.id.cell8Minus)
        cell9MinusButton = findViewById(R.id.cell9Minus)
        cell1PlusButton = findViewById(R.id.cell1Plus)
        cell2PlusButton = findViewById(R.id.cell2Plus)
        cell3PlusButton = findViewById(R.id.cell3Plus)
        cell4PlusButton = findViewById(R.id.cell4Plus)
        cell5PlusButton = findViewById(R.id.cell5Plus)
        cell6PlusButton = findViewById(R.id.cell6Plus)
        cell7PlusButton = findViewById(R.id.cell7Plus)
        cell8PlusButton = findViewById(R.id.cell8Plus)
        cell9PlusButton = findViewById(R.id.cell9Plus)
        cell1ValueTextBox = findViewById(R.id.cell1Value)
        cell2ValueTextBox = findViewById(R.id.cell2Value)
        cell3ValueTextBox = findViewById(R.id.cell3Value)
        cell4ValueTextBox = findViewById(R.id.cell4Value)
        cell5ValueTextBox = findViewById(R.id.cell5Value)
        cell6ValueTextBox = findViewById(R.id.cell6Value)
        cell7ValueTextBox = findViewById(R.id.cell7Value)
        cell8ValueTextBox = findViewById(R.id.cell8Value)
        cell9ValueTextBox = findViewById(R.id.cell9Value)
        platinumValueTextBox = findViewById(R.id.platinumValue)
        goldValueTextBox = findViewById(R.id.goldValue)
        silverValueTextBox = findViewById(R.id.silverValue)
        cuprumValueTextBox = findViewById(R.id.cuprumValue)
        otherNotesTextBox = findViewById(R.id.otherNotes)
    }

    private fun textChangeListner(){
        healthTextBox.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) { health = healthTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        healthTextBox2.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) { safetyHealth = healthTextBox2.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell1ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell1Value = cell1ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell2ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell2Value = cell2ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell3ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell3Value = cell3ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell4ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell4Value = cell4ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell5ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell5Value = cell5ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell6ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell6Value = cell6ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell7ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell7Value = cell7ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell8ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell8Value = cell8ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cell9ValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cell9Value = cell9ValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        platinumValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { platinumValue = platinumValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        goldValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { goldValue = goldValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        silverValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { silverValue = silverValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
        cuprumValueTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { cuprumValue = cuprumValueTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        otherNotesTextBox.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) { otherNotes = otherNotesTextBox.text.toString()}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun buttonClickListners(){
        plus5button.setOnClickListener{healthTextBox.setText(calcHP(health, 5))}
        plus1button.setOnClickListener{healthTextBox.setText(calcHP(health, 1))}
        minus1button.setOnClickListener{healthTextBox.setText(calcHP(health, -1))}
        minus5button.setOnClickListener{healthTextBox.setText(calcHP(health, -5))}

        plus5button2.setOnClickListener{healthTextBox2.setText(calcHP(safetyHealth, 5))}
        plus1button2.setOnClickListener{healthTextBox2.setText(calcHP(safetyHealth, 1))}
        minus1button2.setOnClickListener{healthTextBox2.setText(calcHP(safetyHealth, -1))}
        minus5button2.setOnClickListener{healthTextBox2.setText(calcHP(safetyHealth, -5))}

        cell1PlusButton.setOnClickListener{cell1ValueTextBox.setText(calcHP(cell1Value, 1, true))}
        cell2PlusButton.setOnClickListener{cell2ValueTextBox.setText(calcHP(cell2Value, 1, true))}
        cell3PlusButton.setOnClickListener{cell3ValueTextBox.setText(calcHP(cell3Value, 1, true))}
        cell4PlusButton.setOnClickListener{cell4ValueTextBox.setText(calcHP(cell4Value, 1, true))}
        cell5PlusButton.setOnClickListener{cell5ValueTextBox.setText(calcHP(cell5Value, 1, true))}
        cell6PlusButton.setOnClickListener{cell6ValueTextBox.setText(calcHP(cell6Value, 1, true))}
        cell7PlusButton.setOnClickListener{cell7ValueTextBox.setText(calcHP(cell7Value, 1, true))}
        cell8PlusButton.setOnClickListener{cell8ValueTextBox.setText(calcHP(cell8Value, 1, true))}
        cell9PlusButton.setOnClickListener{cell9ValueTextBox.setText(calcHP(cell9Value, 1, true))}

        cell1MinusButton.setOnClickListener{cell1ValueTextBox.setText(calcHP(cell1Value, -1, true))}
        cell2MinusButton.setOnClickListener{cell2ValueTextBox.setText(calcHP(cell2Value, -1, true))}
        cell3MinusButton.setOnClickListener{cell3ValueTextBox.setText(calcHP(cell3Value, -1, true))}
        cell4MinusButton.setOnClickListener{cell4ValueTextBox.setText(calcHP(cell4Value, -1, true))}
        cell5MinusButton.setOnClickListener{cell5ValueTextBox.setText(calcHP(cell5Value, -1, true))}
        cell6MinusButton.setOnClickListener{cell6ValueTextBox.setText(calcHP(cell6Value, -1, true))}
        cell7MinusButton.setOnClickListener{cell7ValueTextBox.setText(calcHP(cell7Value, -1, true))}
        cell8MinusButton.setOnClickListener{cell8ValueTextBox.setText(calcHP(cell8Value, -1, true))}
        cell9MinusButton.setOnClickListener{cell9ValueTextBox.setText(calcHP(cell9Value, -1, true))}
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