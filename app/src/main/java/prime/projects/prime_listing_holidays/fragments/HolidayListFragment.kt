package prime.projects.prime_listing_holidays.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.json.JSONArray
import prime.projects.prime_listing_holidays.R
import prime.projects.prime_listing_holidays.adapter.HolidayAdapter
import prime.projects.prime_listing_holidays.data.Holidays
import prime.projects.prime_listing_holidays.databinding.FragmentHolidayListBinding
import prime.projects.prime_listing_holidays.events.HolidayListClickListener
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class HolidayListFragment : Fragment(), HolidayListClickListener {

    private var binding: FragmentHolidayListBinding ?= null

    private lateinit var adapter: HolidayAdapter

    private var viewItems: ArrayList<Holidays> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val listBinding = FragmentHolidayListBinding.inflate(inflater, container, false)
        binding = listBinding
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HolidayAdapter(viewItems, this)
        binding?.apply {
            listHolidayFragment = this@HolidayListFragment
            holidayAdapter = adapter
        }
        addItemsFromJSON()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun launchToMessage(){
        findNavController().navigate(R.id.action_holidayListFragment_to_holidayMessageFragment)
    }

    override fun onHolidayClicked(holidays: Holidays) {
        for(holiday in 1..24){
            if (holiday == 1){
                launchToMessage()
                break
            }
        }
    }

    private fun addItemsFromJSON(){
        try {
            val jsonDataString = readJSONDataFromFile()
            val jsonArray = JSONArray(jsonDataString)

            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val name = itemObj.getString("name")
                val date = itemObj.getString("date")
                val holidays = Holidays(name, date)
                viewItems.add(holidays)
            }

        } catch (e: Exception){
            Toast.makeText(requireActivity(), "Here is the $e", Toast.LENGTH_SHORT).show()
        }
    }

    @Throws(IOException::class)
    private fun readJSONDataFromFile(): String {
        var inputStream: InputStream? = null
        val builder = StringBuilder()
        try {
            var jsonString: String?
            inputStream = resources.openRawResource(R.raw.holidays)
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, "UTF-8")
            )
            while (bufferedReader.readLine().also { jsonString = it } != null) {
                builder.append(jsonString)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)
    }


}