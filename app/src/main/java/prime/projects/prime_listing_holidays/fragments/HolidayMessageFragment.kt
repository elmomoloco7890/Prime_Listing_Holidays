package prime.projects.prime_listing_holidays.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.navigation.fragment.findNavController
import prime.projects.prime_listing_holidays.R
import prime.projects.prime_listing_holidays.databinding.FragmentHolidayMessageBinding


class HolidayMessageFragment : DialogFragment() {

    private lateinit var binding: FragmentHolidayMessageBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val messageHolidayBinding = FragmentHolidayMessageBinding.inflate(inflater,  null, false)
            binding = messageHolidayBinding
            return builder.setView(binding.root).create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            messageHolidayFragment = this@HolidayMessageFragment
        }
    }

    fun okayClicked(){
        findNavController().navigate(R.id.action_holidayMessageFragment_to_holidayListFragment)
        dismiss()
    }

    fun cancelledClicked(){
        findNavController().navigate(R.id.action_holidayMessageFragment_to_holidayLauncherFragment)
        dismiss()
    }


}