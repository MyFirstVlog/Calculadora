 package com.alejoestrada.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
    var num1: Double= 0.0
    var num2: Double = 0.0
    var operacion: Int=0
    companion object{
       private const val suma = 1
       private const val resta = 2
       private const val multi= 3
       private const val divi = 4
       private const val noOp= 0
    }
                                                                      
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //numeros
        numero1_botton.setOnClickListener {numeroPresionado("1")}
        numero2_botton.setOnClickListener {numeroPresionado("2")}
        numero3_botton.setOnClickListener {numeroPresionado("3")}
        numero4_botton.setOnClickListener {numeroPresionado("4")}
        numero5_button.setOnClickListener {numeroPresionado("5")}
        numero6_button.setOnClickListener {numeroPresionado("6")}
        numero7_botton2.setOnClickListener {numeroPresionado("7")}
        numero8_button2.setOnClickListener {numeroPresionado("8")}
        numero9_botton2.setOnClickListener {numeroPresionado("9")}
        numero0_botton.setOnClickListener {numeroPresionado("0")}
        numeropto_botton.setOnClickListener {numeroPresionado(".")}
        //ops
        suma_botton2.setOnClickListener {operations(suma)}
        resta_botton.setOnClickListener {operations(resta)}
        numeromulti_botton.setOnClickListener {operations(multi)}
        numerodivi_botton.setOnClickListener {operations(divi)}

         ac_button.setOnClickListener {
            num1=0.0
            num2=0.0
            resultado_edit_text.setText("")
            operacion= noOp                  
         }



        numeroigual_botton.setOnClickListener {
               var resultado = when(operacion){
                   suma -> num1 + num2
                   resta -> num1 - num2
                   multi -> num1 * num2
                   divi -> num1 / num2
                   else -> 0
               }
                num1=resultado.toString().toDouble()
                resultado_edit_text.setText(resultado.toString())
                historialnum_edit_text.setText(resultado.toString())
        }

    }

     private fun numeroPresionado(digito: String){

         var Conca=resultado_edit_text.text.toString() + digito
         resultado_edit_text.text=Conca
         if(operacion == noOp){
         num1= resultado_edit_text.text.toString().toDouble()
         }else{
         num2 = resultado_edit_text.text.toString().toDouble()
         }
     }
     private fun operations(operacion: Int){
         this.operacion = operacion

        resultado_edit_text.setText("")
                                       
     }


}