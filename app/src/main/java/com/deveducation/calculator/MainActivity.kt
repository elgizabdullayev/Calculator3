package com.deveducation.calculator

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var displayOperations : TextView
    private lateinit var but7 : Button
    private lateinit var but8 : Button
    private lateinit var but9 : Button
    private lateinit var but4 : Button
    private lateinit var but5 : Button
    private lateinit var but6 : Button
    private lateinit var but1 : Button
    private lateinit var but2 : Button
    private lateinit var but3 : Button
    private lateinit var but0 : Button
    private lateinit var but00 : Button
    private lateinit var butClear : Button
    private lateinit var butDot : Button
    private lateinit var butDelete : Button
    private lateinit var butDivide : Button
    private lateinit var butMultiply : Button
    private lateinit var butPlus : Button
    private lateinit var butMinus : Button
    private lateinit var butEqual : Button
    private lateinit var displayResult : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    displayOperations = findViewById(R.id.displayOperations)
        but7 = findViewById(R.id.but7)
        but8 = findViewById(R.id.but8)
        but9 = findViewById(R.id.but9)
        but4 = findViewById(R.id.but4)
        but5 = findViewById(R.id.but5)
        but6 = findViewById(R.id.but6)
        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but0 = findViewById(R.id.but0)
        but00 = findViewById(R.id.but00)
        butClear = findViewById(R.id.butClear)
        butDot = findViewById(R.id.butDot)
        butDelete = findViewById(R.id.butDelete)
        butDivide = findViewById(R.id.butDivide)
        butMultiply = findViewById(R.id.butMultiply)
        butPlus = findViewById(R.id.butPlus)
        butMinus = findViewById(R.id.butMinus)
        butEqual = findViewById(R.id.butEqual)
        displayResult = findViewById(R.id.displayResult)
    }
    var firstZero : Boolean = false
    var existingDot : Boolean = false
    var haveSign : Boolean = true
    var isNewOp : Boolean = true
    val numbers : MutableList<Double> = mutableListOf()
    val signs : MutableList<String> = mutableListOf()
    lateinit var temproary : String
    var symbCount : Int = 0
    var previousResult : Double = 0.0
    var haveDot : Boolean = true
    var lastOp : Boolean = false
    fun numbers(view: View) {
        if(isNewOp == true ){
            displayOperations.text = ""
                existingDot = false
                firstZero = false
                isNewOp = true
                numbers.clear()
                signs.clear()
                temproary = ""
                displayResult.text = ""
                symbCount = 0

        }
        isNewOp = false
        var butclick : String = displayOperations.text.toString()
        var buttonSelect : Button = view as Button

        when(buttonSelect.id){
            but7.id -> {if(firstZero==false){
                butclick += "7"
                haveSign = false
                haveDot = false
                lastOp = false
            displayOperations.text = butclick}
            }
            but8.id -> {if(firstZero==false){
                butclick += "8"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but9.id -> {if(firstZero==false){
                butclick += "9"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but4.id -> {if(firstZero==false){
                butclick += "4"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but5.id -> {if(firstZero==false){
                butclick += "5"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but6.id -> {if(firstZero==false){
                butclick += "6"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but1.id -> {if(firstZero==false){
                butclick += "1"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but2.id -> {if(firstZero==false){
                butclick += "2"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but3.id -> {if(firstZero==false){
                butclick += "3"
                haveSign = false
                haveDot = false
                lastOp = false
                displayOperations.text = butclick}
            }
            but0.id -> {if(firstZero==false){
                butclick += "0"
                haveDot = false
                lastOp = false
                if(existingDot == true){
                firstZero = false
                }
                else if (existingDot == false && displayOperations.text == "" || haveSign == true) {
                    firstZero = true
                    haveSign = false
                }
                displayOperations.text = butclick}
            }
            but00.id -> {if ((displayOperations.text != "" && firstZero == false && haveSign == false) || haveDot==true) {
                butclick += "00"
                displayOperations.text = butclick}

            }
            butDot.id -> {if (existingDot == false && displayOperations.text != "" && haveSign == false) {butclick += "."
                existingDot = true
                firstZero = false
                haveDot = true
            displayOperations.text = butclick}
            }

        }
    }

    fun butClear(view: View) {
        var clean : String = ""
        var buttonSelect : Button = view as Button
        when(buttonSelect.id){
            butClear.id -> { displayOperations.text = clean
                existingDot = false
                firstZero = false
                isNewOp = true
            numbers.clear()
            signs.clear()
                temproary = ""
                displayResult.text = clean
                symbCount = 0
            }
        }

    }

    fun delete(view: View) {
        var buttonSelect : Button = view as Button
        var temp : String = displayOperations.text.toString()
        when(buttonSelect.id){
            butDelete.id -> {
                if (displayOperations.text != "") {
                    if(displayOperations.text.endsWith(".")) {
                     existingDot = false
                        displayOperations.text = temp.substring(0, temp.length - 1)
                    }
                    else{
                    displayOperations.text = temp.substring(0, temp.length - 1)
                    }
                if(displayOperations.text == "") {
                  firstZero = false
                    existingDot = false
                    isNewOp = true
                }
            }
            }
        }
    }

    fun mathOp(view: View) {
        var butclick: String = displayOperations.text.toString()
        var buttonSelect: Button = view as Button
        when (buttonSelect.id) {
            butDivide.id -> {
                if (displayOperations.text != "" && haveSign == false) {

                    butclick += "/"
                    var removed : String =""
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    removed = temproary.drop(symbCount)

                    symbCount = temproary.lastIndex+2
                    signs.add("/")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                }
            }
            butMultiply.id -> {
                if (displayOperations.text != "" && haveSign == false) {
                    if(lastOp == true){
                        displayOperations.text = previousResult.toString()
                        butclick = displayOperations.text.toString()
                    }

                    butclick += "*"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)
                    symbCount = temproary.lastIndex+2
                    signs.add("*")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                }
            }
            butPlus.id -> {
                if (displayOperations.text != "" && haveSign == false) {


                    butclick += "+"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)
                    symbCount = temproary.lastIndex+2
                    signs.add("+")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                }
            }
            butMinus.id -> {
                if (displayOperations.text != "" && haveSign == false) {


                    butclick += "-"
                    temproary = displayOperations.text.toString()
                    displayOperations.text = butclick

                    var removed : String = temproary.drop(symbCount)

                    symbCount = temproary.lastIndex+2
                    signs.add("-")
                    numbers.add(removed.toDouble())
                    haveSign = true
                    existingDot = false
                    temproary=""
                }
            }
        }
    }

    fun resultCalc(view: View) {
        var buttonSelect: Button = view as Button

        when (buttonSelect.id){
            butEqual.id -> {
                var result : Double = 0.0
                var removed : String = ""
                temproary = displayOperations.text.toString()
               removed =  temproary.drop(symbCount)
              numbers.add(removed.toDouble())

                (0..signs.size).forEach(){
                    if(signs.contains("/") || signs.contains("*")){

                        if(signs.contains("/") && signs.contains("*")){
                            if(signs.indexOf("/") < signs.indexOf("*")) {
                                var index : Int = signs.indexOf("/")
                                var buf: Double = numbers[index] / numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                            else{
                                var index : Int = signs.indexOf("*")
                                var buf: Double = numbers[index] * numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                        }
                        else{
                            if(signs.contains("/")){
                                var index : Int = signs.indexOf("/")
                                var buf: Double = numbers[index] / numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                            else if (signs.contains("*")){
                                var index : Int = signs.indexOf("*")
                                var buf: Double = numbers[index] * numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                        }
                    }
                    else if(signs.contains("+") || signs.contains("-")) {

                        if (signs.contains("+") && signs.contains("-")) {
                            if (signs.indexOf("+") < signs.indexOf("-")) {
                                var index: Int = signs.indexOf("+")
                                var buf: Double = numbers[index] + numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            } else {
                                var index: Int = signs.indexOf("-")
                                var buf: Double = numbers[index] - numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                        } else {
                            if (signs.contains("+")) {
                                var index: Int = signs.indexOf("+")
                                var buf: Double = numbers[index] + numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            } else if (signs.contains("-")) {
                                var index: Int = signs.indexOf("-")
                                var buf: Double = numbers[index] - numbers[index + 1]
                                numbers.removeAt(index)
                                numbers.removeAt(index)
                                signs.removeAt(index)
                                numbers.add(index, buf)
                                result = numbers[index]
                            }
                        }
                    }
                }

                displayResult.text = result.toString()
                previousResult = result
                isNewOp=true
                lastOp = true

                }
            }
        }

    }