package com.example.paymentappdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.paymentappdemo.databinding.FragmentSendMoneyBinding


class SendMoneyFragment : Fragment() {
    private var _binding: FragmentSendMoneyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            val person = binding.editPersonName.text.toString()
            if (person.length > 3){
                val dir = SendMoneyFragmentDirections.actionSendMoneyFragmentToMoneyAmountFragment(person)
                findNavController().navigate(dir)
            }else{
                binding.wrapPersonName.error = "Person name is invalid"
                binding.editPersonName.requestFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}