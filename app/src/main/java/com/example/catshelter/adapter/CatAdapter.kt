package com.example.catshelter.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.catshelter.R
import com.example.catshelter.data.model.Cat

// der Adapter braucht den Context um auf String Resourcen zuzugreifen
// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class CatAdapter(
    private val context: Context,
    private val dataset: List<Cat>
) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val catImage = view.findViewById<ImageView>(R.id.cat_image)
        val catName = view.findViewById<TextView>(R.id.cat_name)
        val catAge = view.findViewById<TextView>(R.id.cat_age)
        val catWeight = view.findViewById<TextView>(R.id.cat_weight)

        val adoptButton = view.findViewById<TextView>(R.id.cat_adopt_button)
        val donateButton = view.findViewById<TextView>(R.id.cat_donate_button)
    }

    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_item, parent, false)

        return ViewHolder(adapterLayout)
    }

    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = dataset[position]

        holder.catImage.setImageResource(cat.imageResource)
        holder.catName.text = cat.name
        holder.catAge.text = "${cat.age} Monate"
        holder.catWeight.text = "${cat.weight} kg"

        holder.adoptButton.setOnClickListener {
            Toast.makeText(context,"${cat.name} freut sich auf ein neues zu Hause",Toast.LENGTH_SHORT).show()
        }
        holder.donateButton.setOnClickListener {
            Toast.makeText(context,"${cat.name} wird sich über die Spende freuen",Toast.LENGTH_SHORT).show()
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}