package com.example.spinnertutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.example.spinnertutorial.network.RequestModel
import com.example.spinnertutorial.network.RestApiManager


class ScanCard : AppCompatActivity() {

    // VARIABLES
    lateinit var myEditText: EditText
    var cardID: String = ""
    lateinit var showCardID: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_card)

        showCardID = findViewById(R.id.tv_card_info)
        myEditText = findViewById(R.id.et_cardID)
        //myEditText.showSoftInputOnFocus = false

        // waiting for card scan
        enterPress(myEditText)


    }


    fun enterPress(editText: EditText) {
        /*
        editText.setOnEditorActionListener { _, actionId, event ->
            // If triggered by an enter key, this is the event; otherwise, this is null.
            //if (event == null) return@setOnEditorActionListener false
            cardID = editText.text.toString()

            //Toast.makeText(this, "Pressed second enter, Card ID: $cardID", Toast.LENGTH_SHORT).show()

            return@setOnEditorActionListener true
        }

         */
        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                cardID = editText.text.toString()
                //Toast.makeText(this, "Pressed second enter, Card ID: $cardID", Toast.LENGTH_SHORT).show()
                getUserData(cardID)
                return@OnKeyListener true
            }
            false
        })

    }

    private fun getUserData(cardID: String) {
        val apiService = RestApiManager()
        val userInfo = RequestModel(
            rfid = cardID
            //rfid = "1834257108"
        )
        apiService.getUserData(userInfo) {
            if (it != null) {
                if (it.size != 0) {
                    showCardID.text = it[0].userFirstName
                    //Toast.makeText(this, it[0].userFirstName, Toast.LENGTH_SHORT).show()
                    Log.d("Response_","${it[0].userFirstName}")
                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)

                }else{
                    showCardID.text = "Problemek s kartou visit user office"
                    //Toast.makeText(this, "Problem s kartou", Toast.LENGTH_SHORT).show()
                    Log.d("Response_","Problem s kartou")
                }
                }

            }
        }


    }


