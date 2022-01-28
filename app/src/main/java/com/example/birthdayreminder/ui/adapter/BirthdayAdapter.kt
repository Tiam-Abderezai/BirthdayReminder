package com.example.birthdayreminder.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.birthdayreminder.data.model.Birthday
import com.example.birthdayreminder.databinding.ItemBirthdayBinding
import com.example.birthdayreminder.ui.view.ListFragmentDirections
import kotlinx.android.synthetic.main.item_birthday.view.*
import javax.inject.Inject

class BirthdayAdapter @Inject constructor(
) : RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder>() {
    private val birthdays = mutableListOf<Birthday>()
    private val TAG = "BirthdayAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayViewHolder {
        val binding = ItemBirthdayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BirthdayViewHolder(binding)
    }

    override fun getItemCount(): Int = birthdays.size

    override fun onBindViewHolder(holder: BirthdayViewHolder, position: Int) {
        val item = birthdays[position]
        Log.d(TAG, "onBindViewHolder: $item")
        holder.bind(item)
//        val action =
//            item.let {
//                ListFragmentDirections.actionListFragmentToAddFragment(
//                    it
//                )
//            }
//        holder.itemView.setOnClickListener {
//            action.let { NewsResponse -> it.findNavController().navigate(NewsResponse) }
////            Toast.makeText(holder.itemView.context, articles[position], Toast.LENGTH_SHORT).show()
//        }
    }

    class BirthdayViewHolder(itemView: ItemBirthdayBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val TAG = "BirthdayViewHolder"
        fun bind(birthday: Birthday) {
            val name = birthday.name.toString()
//            val source = birthday.source.name.toString()
            Log.d(TAG, "bind: $name")
            itemView.tv_name.text = name
//            itemView.tv_source.text = source.lowercase()
        }
    }

    fun addData(birthdays: List<Birthday>) {
        this.birthdays.apply {
            println(birthdays.size.toString() + "tiam")
            clear()
            addAll(birthdays)
            notifyDataSetChanged()
        }
    }
}