package cl.desafiolatam.aves.sessionlista.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import cl.desafiolatam.aves.sessionlista.domain.model.Ave
import cl.desafiolatam.avesapp.databinding.AvesItemBinding
import com.squareup.picasso.Picasso

class AvesViewHolder (itemView : View, private val avesItemClickListener: AvesItemClickListener) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
            Picasso.get().load(ave.images?.url).into(binding.ivImageAve)
            tvName.text= ave.name?.spanish
            cvItemAves.setOnClickListener{
                avesItemClickListener.onAvesItemClickListener(ave)
            }

        }


    }
}