package com.example.homeworkten

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Switch
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkten.databinding.ItemRecyclerviewBinding

class ItemsRecyclerAdapter(private val items: MutableList<Option>):  RecyclerView.Adapter<ItemsRecyclerAdapter.ItemsViewHolder>() {


    inner class ItemsViewHolder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

                fun bind(){
                    val option = items[adapterPosition]
                    with(binding){
                        if(option.isRed){
                            ivIcon.setImageResource(option.icon)
                            tvName.text = option.name
                            tvName.setTextColor(Color.parseColor("#f53d00"))
                            }
                        else if (option.arrow == 0){
                            ivIcon.setImageResource(option.icon)
                            tvName.text = option.name
                            constraintParent.removeView(ivArrow)
                            val switch = SwitchCompat(binding.root.context)
                            val layoutParams = ConstraintLayout.LayoutParams(
                                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                ConstraintLayout.LayoutParams.WRAP_CONTENT
                            )
                            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID

                            switch.layoutParams = layoutParams
                            constraintParent.addView(switch)

                        }
                        else if(option.isLanguage){
                            val textView = AppCompatTextView(binding.root.context)
                            val layoutParams = ConstraintLayout.LayoutParams(
                                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                                ConstraintLayout.LayoutParams.WRAP_CONTENT
                            )
                            textView.layoutParams = layoutParams
                            constraintParent.addView(textView)
                            textView.id = View.generateViewId()
                            val constraintSet = ConstraintSet()
                            constraintSet.clone(constraintParent)
                            constraintSet.connect(
                                textView.id,
                                ConstraintSet.END,
                                ivArrow.id,
                                ConstraintSet.START
                            )
                            constraintSet.connect(
                                textView.id,
                                ConstraintSet.TOP,
                                ConstraintSet.PARENT_ID,
                                ConstraintSet.TOP
                            )
                            constraintSet.applyTo(constraintParent)
                            val str = "English (US)"
                            textView.text = str
                            textView.setTextColor(Color.parseColor("#FFFFFF"))
                            textView.setTextSize(17f)
                            ivIcon.setImageResource(option.icon)
                            ivArrow.setImageResource(option.arrow)
                            tvName.text = option.name

                        }

                        else{
                            ivIcon.setImageResource(option.icon)
                            tvName.text = option.name
                            ivArrow.setImageResource(option.arrow)
                        }

                    }

                }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            ItemRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.bind()
    }
}