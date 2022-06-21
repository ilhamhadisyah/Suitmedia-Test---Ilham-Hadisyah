package com.ilhamhadisyah.suitmediatest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import com.ilhamhadisyah.suitmediatest.databinding.ActivityScreen2Binding
import com.ilhamhadisyah.suitmediatest.utils.PreferencesManager

class Screen2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen2Binding
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesManager = PreferencesManager(this)

        binding.userNameTv.text = preferencesManager.nameUser

        binding.guestListBtn.setOnClickListener {
            val intent = Intent(this, Screen4Activity::class.java)
            getResult.launch(intent)
        }

        binding.chooseEventBtn.setOnClickListener {
            val intent = Intent(this, Screen3Activity::class.java)
            getEventResult.launch(intent)
        }


    }

    // Guest Receiver
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == 200) {
                val value: GuestModel? = it.data?.getParcelableExtra<GuestModel>("GUEST")
                binding.guestListBtn.text = "${value?.firstName} ${value?.lastName}"
            }
        }

    // Event Receiver
    private val getEventResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == 201) {
                val value: EventModel? = it.data?.getParcelableExtra<EventModel>("EVENT")
                binding.chooseEventBtn.text = value?.title
            }
        }


}