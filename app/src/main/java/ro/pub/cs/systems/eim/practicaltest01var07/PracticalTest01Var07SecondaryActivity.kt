package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

typealias PracticaTest01Var07SecondaryActivity = PracticalTest01Var07SecondaryActivity

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_secondary)

        val editText1 = findViewById<EditText>(R.id.editTextSecondary1)
        val editText2 = findViewById<EditText>(R.id.editTextSecondary2)
        val editText3 = findViewById<EditText>(R.id.editTextSecondary3)
        val editText4 = findViewById<EditText>(R.id.editTextSecondary4)

        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val buttonProduct = findViewById<Button>(R.id.buttonProduct)

        val val1 = intent.getStringExtra("text1") ?: ""
        val val2 = intent.getStringExtra("text2") ?: ""
        val val3 = intent.getStringExtra("text3") ?: ""
        val val4 = intent.getStringExtra("text4") ?: ""

        editText1.setText(val1)
        editText2.setText(val2)
        editText3.setText(val3)
        editText4.setText(val4)

        val num1 = val1.toIntOrNull() ?: 0
        val num2 = val2.toIntOrNull() ?: 0
        val num3 = val3.toIntOrNull() ?: 0
        val num4 = val4.toIntOrNull() ?: 0

        buttonSum.setOnClickListener {
            val sum = num1 + num2 + num3 + num4
            val resultIntent = Intent().apply {
                putExtra("RESULT", sum.toString())
                putExtra("RESULT_VALUE", sum)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        buttonProduct.setOnClickListener {
            val product = num1 * num2 * num3 * num4
            val resultIntent = Intent().apply {
                putExtra("RESULT", product.toString())
                putExtra("RESULT_VALUE", product)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
