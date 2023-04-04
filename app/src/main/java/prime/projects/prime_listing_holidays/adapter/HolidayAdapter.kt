package prime.projects.prime_listing_holidays.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import prime.projects.prime_listing_holidays.data.Holidays
import prime.projects.prime_listing_holidays.databinding.HolidayListItemsBinding
import prime.projects.prime_listing_holidays.events.HolidayListClickListener

class HolidayAdapter(
    private val list: ArrayList<Holidays>,
    private val clickingListener: HolidayListClickListener
    ): RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder>() {
        private lateinit var binding: HolidayListItemsBinding

        class HolidayViewHolder(private var holidayItems: HolidayListItemsBinding):RecyclerView.ViewHolder(holidayItems.root){
            fun bind(holdItem: Holidays, listener: HolidayListClickListener){
                holidayItems.holidays = holdItem
                holidayItems.holidayClicked = listener
                holidayItems.executePendingBindings()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holidayItemBinding = HolidayListItemsBinding.inflate(inflater, parent, false)
        binding = holidayItemBinding
        return HolidayViewHolder(holidayItemBinding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) =
        holder.bind(list[position], clickingListener)
}