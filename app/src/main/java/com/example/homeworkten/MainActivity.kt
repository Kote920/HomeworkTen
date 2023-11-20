package com.example.homeworkten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkten.databinding.ActivityMainBinding
import com.example.homeworkten.databinding.ItemRecyclerviewBinding

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<Option>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingItem: ItemRecyclerviewBinding
    private lateinit var adapter: ItemsRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        setUpEquipmentRecycler()
    }
    private fun setUpEquipmentRecycler() {
        adapter = ItemsRecyclerAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }

    private fun setData(){
                items.also {
                    it.add(Option(R.drawable.profile, "Profile",))
                    it.add(Option(R.drawable.location, "Address",))
                    it.add(Option(R.drawable.not, "Notification",))
                    it.add(Option(R.drawable.wallet, "Payment",))
                    it.add(Option(R.drawable.security2, "Security",))
                    it.add(Option(R.drawable.language, "Language", isLanguage = true))
                    it.add(Option(R.drawable.eye, "Dark Mode",arrow = 0))
                    it.add(Option(R.drawable.lock_2, "Privacy Policy"))
                    it.add(Option(R.drawable.exclamation, "Help Center"))
                    it.add(Option(R.drawable.friends, "Invite Friends"))
                    it.add(Option(R.drawable.log_out, "Log out", isRed = true))
                }

    }
}