package pe.edu.upeu.appupeunative.ui.persona.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pe.edu.upeu.appupeunative.databinding.ItemPersonaBinding
import pe.edu.upeu.appupeunative.modelo.Persona
import pe.edu.upeu.appupeunative.ui.persona.viewholder.PersonaViewHolder

class PersonaListAdapter(
    private val onItemClicked: (Persona, /*ImageView,*/ View)->Unit
):ListAdapter<Persona, PersonaViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder =
        PersonaViewHolder(
            ItemPersonaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) =holder.bind(getItem(position), onItemClicked)

  companion object{
      private val DIFF_CALLBACK=object :DiffUtil.ItemCallback<Persona>(){
          override fun areItemsTheSame(oldItem: Persona, newItem: Persona): Boolean = oldItem.id==newItem.id
          override fun areContentsTheSame(oldItem: Persona, newItem: Persona): Boolean = oldItem==newItem
      }
  }
}