package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class PracticalTest01Var07MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText

    private lateinit var buttonSet: Button
    private lateinit var buttonRandom: Button

    private val secondaryActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Result: OK", Toast.LENGTH_SHORT).show()
        } else if (result.resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Result: CANCEL", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)

        buttonSet = findViewById(R.id.buttonSet)
        buttonRandom = findViewById(R.id.buttonRandom)

        buttonRandom.setOnClickListener {
            editText1.setText(Random.nextInt(1, 100).toString())
            editText2.setText(Random.nextInt(1, 100).toString())
            editText3.setText(Random.nextInt(1, 100).toString())
            editText4.setText(Random.nextInt(1, 100).toString())
        }

        buttonSet.setOnClickListener {
            val val1 = editText1.text.toString()
            val val2 = editText2.text.toString()
            val val3 = editText3.text.toString()
            val val4 = editText4.text.toString()

            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java).apply {
                putExtra("EXTRA_TEXT", "$val1, $val2, $val3, $val4")
                putExtra("EXTRA_TEXT_1", val1)
                putExtra("EXTRA_TEXT_2", val2)
                putExtra("EXTRA_TEXT_3", val3)
                putExtra("EXTRA_TEXT_4", val4)
            }
            secondaryActivityLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("SAVED_TEXT_1", editText1.text.toString())
        outState.putString("SAVED_TEXT_2", editText2.text.toString())
        outState.putString("SAVED_TEXT_3", editText3.text.toString())
        outState.putString("SAVED_TEXT_4", editText4.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("SAVED_TEXT_1")) {
            editText1.setText(savedInstanceState.getString("SAVED_TEXT_1"))
        }
        if (savedInstanceState.containsKey("SAVED_TEXT_2")) {
            editText2.setText(savedInstanceState.getString("SAVED_TEXT_2"))
        }
        if (savedInstanceState.containsKey("SAVED_TEXT_3")) {
            editText3.setText(savedInstanceState.getString("SAVED_TEXT_3"))
        }
        if (savedInstanceState.containsKey("SAVED_TEXT_4")) {
            editText4.setText(savedInstanceState.getString("SAVED_TEXT_4"))
        }
    }
}
