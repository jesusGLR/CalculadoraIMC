package lizarraga.jesus.asignacion_calculadora_imc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Variables
    val etPeso: EditText = findViewById(R.id.etKilos)
    val etEstatura: EditText = findViewById(R.id.etMetros)
    val btnCalcula: Button = findViewById(R.id.btnCalcula)
    val txtResultado: TextView = findViewById(R.id.tvResultado)
    val txtEstado: TextView = findViewById(R.id.tvResultado)

    @SuppressLint("ResourceAsColor")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Evento clic Button
        btnCalcula.setOnClickListener {
            if (!this.etEstatura.text.isBlank() || this.etPeso.text.isBlank()) {


                var imcNum = calculaIMC(this.etEstatura.text.toString().toDouble(),
                    this.etPeso.text.toString().toDouble())

                this.txtResultado.setText(imcNum.toString())

                //Se obtiene el estado del usuario
                var estado = obtenEstado(imcNum)
                this.txtEstado.setText(estado)

                //Se aniade el color dependiendo del estado
                when (estado) {
                    "Bajo peso" -> this.txtEstado.setBackgroundColor(R.color.colorBrown)
                    "Saludable" -> this.txtEstado.setBackgroundColor(R.color.colorGreen)
                    "Sobrepeso" -> this.txtEstado.setBackgroundColor(R.color.colorGreenish)
                    "Obesidad de grado 1" -> this.txtEstado.setBackgroundColor(R.color.colorYellow)
                    "Obesidad de grado 2" -> this.txtEstado.setBackgroundColor(R.color.colorOrange)
                    "Obesidad de grado 3" -> this.txtEstado.setBackgroundColor(R.color.colorRed)
                }

            }


        }


        }
    }
fun calculaIMC(altura: Double, peso: Double): Double {
    val imc: Double = (peso / (Math.pow(altura, 2.0)))
    return imc

}

fun obtenEstado(imc: Double): String {
    return when {
        imc < 18.5 -> return "Saludable"
        imc >= 18.5 && imc <= 24.9 -> return "Sobrepeso"
        imc > 24.9 && imc <= 29.9 -> return "Obesidad de grado 1"
        imc > 34.9 && imc <= 39.9 -> return "Obesidad de grado 2"
        imc >= 40 -> return "Obesidad de grado 3"
        else -> "Sin valores"
    }
}




