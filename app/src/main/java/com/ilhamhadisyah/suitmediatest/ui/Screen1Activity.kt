package com.ilhamhadisyah.suitmediatest.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.github.dhaval2404.imagepicker.ImagePicker
import com.ilhamhadisyah.suitmediatest.databinding.ActivityScreen1Binding
import com.ilhamhadisyah.suitmediatest.utils.DialogHelper
import com.ilhamhadisyah.suitmediatest.utils.PreferencesManager
import com.ilhamhadisyah.suitmediatest.utils.isPalindrome

class Screen1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen1Binding
    private lateinit var dialog: DialogHelper
    private lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesManager = PreferencesManager(this)

        dialog = DialogHelper(this)

        binding.checkBtn.setOnClickListener {

            val palindromeText = binding.checkPalindromeEt.text.toString()
            if (palindromeText.isNullOrEmpty()) {
                binding.checkPalindromeInpLayout.error = "Field cannot be empty"
            } else {
                if (palindromeText.isPalindrome()) {
                    dialog.createDialog("Warning", "The text IS palindrome")
                } else {
                    dialog.createDialog("Warning", "The text IS NOT palindrome")
                }
            }
        }
        binding.checkPalindromeEt.doOnTextChanged { _, _, _, _ ->
            binding.checkPalindromeInpLayout.isErrorEnabled = false
        }

        binding.userAvatar.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(1024)
                .maxResultSize(500, 500)
                .start()
        }

        binding.nextBtn.setOnClickListener {
            val username = binding.nameUserEt.text.toString()
            if (username.isNullOrEmpty()) {
                binding.nameUserInpLayout.error = "Name cannot be empty!"
            } else {
                preferencesManager.nameUser = username
                val intent = Intent(this, Screen2Activity::class.java)
                startActivity(intent)
            }
        }

        binding.nameUserEt.doOnTextChanged { _, _, _, _ ->
            binding.nameUserInpLayout.isErrorEnabled = false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri = data?.data!!
            binding.userAvatar.setImageURI(uri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        }
    }
}