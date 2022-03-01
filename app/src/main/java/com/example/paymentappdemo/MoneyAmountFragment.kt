package com.example.paymentappdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.paymentappdemo.databinding.FragmentMoneyAmountBinding


class MoneyAmountFragment : Fragment() {

    private var _binding: FragmentMoneyAmountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoneyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = MoneyAmountFragmentArgs.fromBundle(requireArguments())  // read the bundle
        binding.textPersonName.text = args.personName

        binding.btnConfirm.setOnClickListener {
            val amt = binding.editAmt.text.toString().toFloat() // this will crash ur app if value is blank
            val dir = MoneyAmountFragmentDirections.actionMoneyAmountFragmentToStatusFragment(args.personName,amt)
            findNavController().navigate(dir)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}