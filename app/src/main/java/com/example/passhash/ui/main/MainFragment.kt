package com.example.passhash.ui.main

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.passhash.R
import com.example.passhash.databinding.AddPasswordDialogBinding
import com.example.passhash.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

  private val mMainViewModel: MainViewModel by viewModel()
  private var _binding: FragmentMainBinding? = null
  private val binding get() = _binding!!


  companion object {
    fun newInstance() = MainFragment()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentMainBinding.inflate(inflater, container, false)
    val root: View = binding.root

    initPasswordList()

    return root
  }

  private fun initPasswordList() {
    mMainViewModel.passwordList.observe(viewLifecycleOwner) {
      binding.passwordListTv.text = it.asString()
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    initFab()
  }

  private fun initFab() {
    binding.floatingActionButton.setOnClickListener {
      createSaveNewPasswordDialog()
    }
  }

  private fun createSaveNewPasswordDialog() {
    val dialogBinding = AddPasswordDialogBinding.inflate(layoutInflater)
    AlertDialog.Builder(activity)
      .setView(dialogBinding.root)
      .setCancelable(true)
      .setTitle("Add new password")
      .setNegativeButton("Cancel", null)
      .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
        mMainViewModel.save(dialogBinding.addDialogEdt.text.toString())
      })
      .create()
      .show()
  }
}