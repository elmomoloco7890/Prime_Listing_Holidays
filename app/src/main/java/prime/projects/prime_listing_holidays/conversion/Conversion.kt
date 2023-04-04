package prime.projects.prime_listing_holidays.conversion


import android.icu.text.ListFormatter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import prime.projects.prime_listing_holidays.data.Holidays
import java.lang.reflect.Type


/*

class RecyclerAdapter(context: Context, listRecyclerItem: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val context: Context
    private val listRecyclerItem: List<Any>

    init {
        this.context = context
        this.listRecyclerItem = listRecyclerItem
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView
        private val date: TextView

        init {
            name = itemView.findViewById(R.id.name)
            date = itemView.findViewById(R.id.date)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        return when (i) {
            TYPE -> {
                val layoutView: View = LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.list_item, viewGroup, false
                )
                ItemViewHolder(layoutView)
            }
            else -> {
                val layoutView: View = LayoutInflater.from(viewGroup.context).inflate(
                    R.layout.list_item, viewGroup, false
                )
                ItemViewHolder(layoutView)
            }
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        val viewType = getItemViewType(i)
        when (viewType) {
            TYPE -> {
                val itemViewHolder = viewHolder as ItemViewHolder
                val holidays = listRecyclerItem[i] as Holidays
                itemViewHolder.name.setText(holidays.getName())
                itemViewHolder.date.setText(holidays.getDate())
            }
            else -> {
                val itemViewHolder = viewHolder as ItemViewHolder
                val holidays = listRecyclerItem[i] as Holidays
                itemViewHolder.name.setText(holidays.getName())
                itemViewHolder.date.setText(holidays.getDate())
            }
        }
    }

    override fun getItemCount(): Int {
        return listRecyclerItem.size
    }

    companion object {
        private const val TYPE = 1
    }
}*/

/*var gson = Gson()

var founderListType: Type? = object : TypeToken<ArrayList<Holidays?>?>() {}.type

var founderList: List<Holidays> = gson.fromJson(founderJson, founderListType)*/
