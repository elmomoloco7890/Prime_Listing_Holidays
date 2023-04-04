package prime.projects.prime_listing_holidays.events

import prime.projects.prime_listing_holidays.data.Holidays

interface HolidayListClickListener {
    fun onHolidayClicked(holidays: Holidays)
}