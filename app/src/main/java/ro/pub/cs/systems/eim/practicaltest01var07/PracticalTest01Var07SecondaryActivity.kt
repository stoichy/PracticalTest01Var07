package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_secondary)

        val textViewReceived = findViewById<TextView>(R.id.textViewReceived)
        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        val receivedText = intent.getStringExtra("EXTRA_TEXT") ?: ""
        textViewReceived.text = receivedText

        buttonOk.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        buttonCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}
