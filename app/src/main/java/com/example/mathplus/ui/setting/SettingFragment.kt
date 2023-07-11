package com.example.mathplus.ui.setting

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mathplus.R
import com.example.mathplus.databinding.FragmentSettingBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class SettingFragment : Fragment() {

    private var _binding : FragmentSettingBinding? = null
    val binding get() = _binding!!

    private val viewModel : SettingViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.round.observe(viewLifecycleOwner){
            binding.roundTIET.setText(it.toString())
        }

        viewModel.duration.observe(viewLifecycleOwner){
            binding.durationTIET.setText(it.toString())
        }

        binding.settingsConfirmButton.setOnClickListener {
            val round = binding.roundTIET.text.toString().toInt()
            val duration = (binding.durationTIET.text.toString().toInt())* 1000

            Toast.makeText(requireContext(), "SUCCESS EDIT SETTINGS", Toast.LENGTH_SHORT).show()
            viewModel.saveChanges(round, duration)
            findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
        }

        binding.settingsResetBtn.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("RESET WARNING")
                .setMessage("Are you sure want to reset?")
                .setPositiveButton("YES") { dialog, which ->
                    Toast.makeText(requireContext(), "SUCCESS RESET SETTINGS", Toast.LENGTH_SHORT).show()
                    viewModel.saveChanges(5, 15000)
                    findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
                }
                .setNegativeButton("NO") {dialog, which ->

                }
                .show()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}