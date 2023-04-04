package prime.projects.prime_listing_holidays.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import prime.projects.prime_listing_holidays.R
import prime.projects.prime_listing_holidays.databinding.FragmentHolidayLauncherBinding


class HolidayLauncherFragment : Fragment() {

    private var binding: FragmentHolidayLauncherBinding ?= null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val launcherBinding = FragmentHolidayLauncherBinding.inflate(inflater, container, false)
        binding = launcherBinding
        return launcherBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            holidayLauncherFragment = this@HolidayLauncherFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun onHolidayLaunch(){
        findNavController().navigate(R.id.action_holidayLauncherFragment_to_holidayListFragment)
    }


}