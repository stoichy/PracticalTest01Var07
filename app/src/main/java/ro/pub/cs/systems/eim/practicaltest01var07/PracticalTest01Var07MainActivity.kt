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
            val resultValue = result.data?.getStringExtra("RESULT")
                ?: result.data?.getIntExtra("RESULT_VALUE", 0)?.toString()
            if (resultValue != null) {
                Toast.makeText(this, resultValue, Toast.LENGTH_SHORT).show()
            }
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
            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java).apply {
                putExtra("TEXT_1", editText1.text.toString())
                putExtra("TEXT_2", editText2.text.toString())
                putExtra("TEXT_3", editText3.text.toString())
                putExtra("TEXT_4", editText4.text.toString())
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
