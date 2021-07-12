package com.example.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPin()

        btEnter.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()

        checkPin()
    }

    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }

     fun checkPin (){
         etPinCode1.text.clear()
         etPinCode2.text.clear()
         etPinCode3.text.clear()
         etPinCode4.text.clear()
         val pin = "1"
         etName.visibility = View.INVISIBLE
         etSurname.visibility = View.INVISIBLE
         etAge.visibility = View.INVISIBLE
         etIDNumber.visibility = View.INVISIBLE
         btEnter.visibility = View.INVISIBLE
         etPinCode1.visibility = View.VISIBLE
         etPinCode2.visibility = View.VISIBLE
         etPinCode3.visibility = View.VISIBLE
         etPinCode4.visibility = View.VISIBLE
         tvPrompt.visibility = View.VISIBLE
         etPinCode1.requestFocus()
         etPinCode1.afterTextChanged {
             var pin1 = etPinCode1.text.toString()
             when {

                 //(pin1.compareTo(pin) != 0) -> tvIncorrect.visibility = View.VISIBLE
                 (pin1.equals(pin)) -> etPinCode2.requestFocus()
                 }

             }


         etPinCode2.afterTextChanged {
             var pin2 = etPinCode2.text.toString()
             when {

                 //(pin2.compareTo(pin) != 0) -> tvIncorrect.visibility = View.VISIBLE
                 (pin2.equals(pin)) -> etPinCode3.requestFocus()
             }

         }

         etPinCode3.afterTextChanged {
             var pin3 = etPinCode3.text.toString()
             when {

                 //(pin3.compareTo(pin) != 0) -> tvIncorrect.visibility = View.VISIBLE
                 (pin3.equals(pin)) -> etPinCode4.requestFocus()
             }

         }

         etPinCode4.afterTextChanged {
             var pin4 = etPinCode4.text.toString()
             when {

                 //(pin4.compareTo(pin) != 0) -> tvIncorrect.visibility = View.VISIBLE
                 (pin4).equals(pin) -> {
                     Log.d("MyLog", "PIN is correct")
                     etName.visibility = View.VISIBLE
                     etSurname.visibility = View.VISIBLE
                     etAge.visibility = View.VISIBLE
                     etIDNumber.visibility = View.VISIBLE
                     btEnter.visibility = View.VISIBLE
                 }
             }
         }



     }
    }
