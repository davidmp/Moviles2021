package pe.edu.upeu.appupeunative.ui.persona.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pe.edu.upeu.appupeunative.databinding.ItemPersonaBinding
import pe.edu.upeu.appupeunative.modelo.Persona

class PersonaViewHolder(
    private val binding: ItemPersonaBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(persona: Persona, onItemClicked: (Persona, /*ImageView,*/ View)->Unit){
        binding.itemPersonaNombre.text=persona.nombre
        binding.itemPersonaDni.text="DNI:"+persona.dni
        binding.itmePersonaTelef.text="Telf:"+persona.telefono

        /*binding.imageView.load(producto.nombre){
            placeholder(R.drawable.ic_photo)
            error(R.drawable.ic_broken_image)
        }*/

        /*binding.root.setOnClickListener {
            onItemClicked(producto,binding.imageView, binding.root)
        }*/

        binding.itemPersonaBtnEdit.setOnClickListener {
            Log.i("LLEGA_P", "Imagen:"+persona.id)
            onItemClicked(persona, /*binding.imageView,*/ binding.itemPersonaBtnEdit)
        }

        binding.itemPersonaBtnDelet.setOnClickListener {
            Log.i("LLEGA_P", "Delete:"+persona.id)
            onItemClicked(persona, /*binding.imageView,*/ binding.itemPersonaBtnDelet)
        }
        binding.itemPersonaNombre.setOnClickListener {
            Log.i("LLEGA_U", "Editar"+persona.id)
        }

    }
}