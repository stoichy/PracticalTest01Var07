package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class PracticalTest01Var07MainActivity : AppCompatActivity() {

    private val tag = "PracticalTest01Var07"

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText

    private lateinit var buttonSet: Button
    private lateinit var buttonRandom: Button

    private var resultValue: String? = null

    private val secondaryActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            resultValue = result.data?.getStringExtra("RESULT")
                ?: result.data?.getIntExtra("RESULT_VALUE", 0)?.toString()
            resultValue?.let {
                Toast.makeText(this, "result = $it", Toast.LENGTH_SHORT).show()
                Log.d(tag, "result = $it")
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
            editText1.setText(Random.nextInt(1, 10).toString())
            editText2.setText(Random.nextInt(1, 10).toString())
            editText3.setText(Random.nextInt(1, 10).toString())
            editText4.setText(Random.nextInt(1, 10).toString())
        }

        buttonSet.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java).apply {
                putExtra("text1", editText1.text.toString())
                putExtra("text2", editText2.text.toString())
                putExtra("text3", editText3.text.toString())
                putExtra("text4", editText4.text.toString())
            }
            secondaryActivityLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved1", editText1.text.toString())
        outState.putString("saved2", editText2.text.toString())
        outState.putString("saved3", editText3.text.toString())
        outState.putString("saved4", editText4.text.toString())
        outState.putString("result", resultValue)
        Log.d(tag, "result = $resultValue")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey("saved1")) {
            editText1.setText(savedInstanceState.getString("saved1"))
        }
        if (savedInstanceState.containsKey("saved2")) {
            editText2.setText(savedInstanceState.getString("saved2"))
        }
        if (savedInstanceState.containsKey("saved3")) {
            editText3.setText(savedInstanceState.getString("saved3"))
        }
        if (savedInstanceState.containsKey("saved4")) {
            editText4.setText(savedInstanceState.getString("saved4"))
        }
        if (savedInstanceState.containsKey("result")) {
            resultValue = savedInstanceState.getString("result")
            resultValue?.let {
                Toast.makeText(this, "result: $it", Toast.LENGTH_SHORT).show()
                Log.d(tag, "restore = $it")
            }
        }
    }
}
