package br.senai.sp.jandira.controlenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

val nota1EditText: EditText
val nota2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val resultado = findViewById<TextView>(R.id.resultado)
        val relatorio = findViewById<TextView>(R.id.relatorio)


        resultado.text = ""
        relatorio.text = ""

        sair.setOnClickListener {
            finish()
        }

        calcular.setOnClickListener {
            nota1EditText = findViewById(R.id.nota1);
            nota2EditText = findViewById(R.id.nota2);

            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()

            if (nota1EditText > 10 || nota2EditText > 10) {
                relatorio.text = ""
                resultado.text = "Nota Invalida!"
                resultado.setTextColor(Color.RED)
            }else {
                val media = (nota1EditText + nota2EditText) / 2

                relatorio.text = "Nota 1 : $nota1EditText\n" +
                        "Nota 2 : $nota2EditText\n" +
                        "Média : $media\n" +
                        "Faltas : $faltas";

                if (media >= 5) {
                    resultado.text = "Aprovado!\n:)"

                    resultado.setTextColor(Color.GREEN)
                } else {
                    resultado.text = "Reprovado!\n:("

                    resultado.setTextColor(Color.RED)
                }
            }

            private fun validarCampos(): Boolean {
                return  nota1EditText.text.isBlank() && nota2EditText.text.isNotBlank()
            }
        }
    }
}