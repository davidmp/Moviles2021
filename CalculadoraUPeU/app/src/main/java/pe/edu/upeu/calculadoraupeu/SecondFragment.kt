package pe.edu.upeu.calculadoraupeu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pe.edu.upeu.calculadoraupeu.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)


        return binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBorrarX=_binding!!.btnBorrar

        var valorA=""
        var operador=' '
        var resultado=""

        _binding!!.btn0.setOnClickListener{_binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"0")}
        _binding!!.btn1.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"1") }
        _binding!!.btn2.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"2") }
        _binding!!.btn3.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"3") }
        _binding!!.btn4.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"4") }
        _binding!!.btn5.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"5") }
        _binding!!.btn6.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"6") }
        _binding!!.btn7.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"7") }
        _binding!!.btn8.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"8") }
        _binding!!.btn9.setOnClickListener { _binding!!.editTxt.setText(_binding!!.editTxt.text.toString()+"9") }

        btnBorrarX.setOnClickListener {_binding!!.editTxt.setText("")}

        _binding!!.btnSum.setOnClickListener {
            valorA=_binding!!.editTxt.text.toString()
            operador='+'
            _binding!!.editTxt.setText("")
        }

        _binding!!.btnRest.setOnClickListener {
            valorA=_binding!!.editTxt.text.toString()
            operador='-'
            _binding!!.editTxt.setText("")
        }

        _binding!!.btnMult.setOnClickListener {
            valorA=_binding!!.editTxt.text.toString()
            operador='*'
            _binding!!.editTxt.setText("")
        }

        _binding!!.btnDiv.setOnClickListener {
            valorA=_binding!!.editTxt.text.toString()
            operador='/'
            _binding!!.editTxt.setText("")
        }

        _binding!!.btnIgual.setOnClickListener {
            when(operador){
                '+'->{
                    resultado=(valorA.toFloat()+_binding!!.editTxt.text.toString().toFloat()).toString()
                    _binding!!.editTxt.setText(resultado)
                }
                '-'->{
                    resultado=(valorA.toFloat()-_binding!!.editTxt.text.toString().toFloat()).toString()
                    _binding!!.editTxt.setText(resultado)
                }
                '*'->{
                    resultado=(valorA.toFloat()*_binding!!.editTxt.text.toString().toFloat()).toString()
                    _binding!!.editTxt.setText(resultado)
                }
                '/'->{
                    resultado=(valorA.toFloat()/_binding!!.editTxt.text.toString().toFloat()).toString()
                    _binding!!.editTxt.setText(resultado)
                }
            }
        }



        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}