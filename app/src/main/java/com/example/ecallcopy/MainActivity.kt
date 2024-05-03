package com.example.ecallcopy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchviewkotlin.LanguageAdapter
import com.example.searchviewkotlin.LanguageData
import java.util.ArrayList
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = LanguageAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {       //Search Title
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }

            for (i in mList) { //Search Location
                if (i.location.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }

        }
    }



    private fun addDataToList() {

        //Emergency
        mList.add(LanguageData("Suwa Seriya","Anywhere" ,"1990" , R.drawable.suwaseriya))

        mList.add(LanguageData("Ambulance / Fire & rescue","" ,"110" , R.drawable.ambulance))
        mList.add(LanguageData("Police Emergency Hotline","" ,"118 / 119" , R.drawable.police))
        mList.add(LanguageData("National Help Desk","" ,"118" , R.drawable.help))
        mList.add(LanguageData("Police","Colombo" ,"119" , R.drawable.police))
        mList.add(LanguageData("Government Help","" ,"1919" , R.drawable.help))

        mList.add(LanguageData("Accident Service","Colombo" ,"011-2691111" , R.drawable.hospital))
        mList.add(LanguageData("Tourist Police","" ,"011-2421052" , R.drawable.hospital))

        //General Hospitals
        mList.add(LanguageData("National Hospital of Sri Lanka","Colombo" ,"0112 691 111" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Kurunegala" ,"0372 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Gampaha" ,"0332 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Anuradhapura " ,"0252 236 461" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Anuradhapura" ,"0252 222 261", R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Ampara" ,"0632 222 261" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Kegalle" ,"0352 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Matale" ,"0662 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Kalutara" ,"0342 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Mannar" ,"0232 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Vavuniya" ,"0242 222 761" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Jaffna" ,"0212 223 348" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital Karapitiya","Galle" ,"0912 232 267" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Nuwara Eliya" ,"0522 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Kilinochchi" ,"0212 285 329" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Matara" ,"0412 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Monaragala" ,"0552 276 261" , R.drawable.hospital))
        mList.add(LanguageData("National Hospital","Kandy" ,"0812 222 261" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Batticaloa" ,"0652 222 261" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Hambantota" ,"0472 256 403" , R.drawable.hospital))
        mList.add(LanguageData("Teaching Hospital","Kurunegala" ,"0372 222 261" , R.drawable.hospital))
        mList.add(LanguageData("Divisional Hospital","Mullaithivu" ,"0212 290 150" , R.drawable.hospital))
        mList.add(LanguageData("General Hospital","Polonnaruwa" ,"0272 222 261" , R.drawable.hospital))

        //Private Hospitals

        mList.add(LanguageData("Suwa Sewana","Anuradhapura" ,"071 858 6560" , R.drawable.hospital))



        //Police Stations
        mList.add(LanguageData("Police Station","Ampara" ,"0632 222 223" , R.drawable.police))
        mList.add(LanguageData("Police Station","Kegalle" ,"0352 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Matale" ,"0662 222 222" , R.drawable.police))
        mList.add(LanguageData("South Police Station","Kalutara" ,"0342 222 222" , R.drawable.police))
        mList.add(LanguageData("North Police Station","Kalutara" ,"0342 237 225" , R.drawable.police))
        mList.add(LanguageData("Office of Superintendent of Police","Kalutara" ,"0342 222 012" , R.drawable.police))
        mList.add(LanguageData("Police Station","Mannar" ,"0232 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Badulla" ,"0552 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Vavuniya" ,"0242 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Jaffna" ,"0213 211 258" , R.drawable.police))
        mList.add(LanguageData("Police Station","Anuradhapura" ,"0252 222 223" , R.drawable.police))
        mList.add(LanguageData("Police Station","Galle" ,"0912 233 333" , R.drawable.police))
        mList.add(LanguageData("Police Station","Nuwara Eliya" ,"0522 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Kilinochchi" ,"0212 285 467" , R.drawable.police))
        mList.add(LanguageData("Police Station","Matara" ,"0412 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Monaragala" ,"0552 276 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Kandy" ,"0812 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Batticaloa" ,"0652 224 422" , R.drawable.police))
        mList.add(LanguageData("Police Station","Hambantota" ,"0472 220 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Gampaha" ,"0332 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Kurunegala" ,"0372 222 222" , R.drawable.police))
        mList.add(LanguageData("Police Station","Mullaitivu" ,"0212 290 120" , R.drawable.police))
        mList.add(LanguageData("Police Station","Polonnaruwa" ,"0272 223 099" , R.drawable.police))

        //Police Stations Colombo District
        mList.add(LanguageData("Sri Lanka Police Headquarters","Colombo" ,"0112 421 111" , R.drawable.police))
        mList.add(LanguageData("Police Station","Cinnamon Gardens" ,"0112 695 411" , R.drawable.police))

        //Fire & Rescue Units
        mList.add(LanguageData("Fire & Rescue Unit","Ampara" ,"0632 223 997" , R.drawable.fire))
        mList.add(LanguageData("Fire & Rescue Unit","Mawanella" ,"0354 927 828" , R.drawable.fire))
        mList.add(LanguageData("Fire Service Department","Colombo" ,"0112 422 222" , R.drawable.fire))
        mList.add(LanguageData("Fire Service Department","Kotahena" ,"0112 430 348" , R.drawable.fire))
        mList.add(LanguageData("City Fire Unit","Matale" ,"077 278 3463" , R.drawable.fire))
        mList.add(LanguageData("Fire Brigade","Kalutara" ,"0342 228 080" , R.drawable.fire))
        mList.add(LanguageData("Fire & Rescue Unit","Badulla" ,"0553 590 131" , R.drawable.fire))
        mList.add(LanguageData("Municipal Fire Service","Jaffna" ,"0213 207 777" , R.drawable.fire))
        mList.add(LanguageData("Fire Brigade","Anuradhapura" ,"0252 227 799" , R.drawable.fire))
        mList.add(LanguageData("Rajarata Fire Service","Anuradhapura" ,"077 740 4097" , R.drawable.fire))
        mList.add(LanguageData("Fire Brigade","Galle" ,"0912 244 445" , R.drawable.fire))
        mList.add(LanguageData("Fire And Rescue Unit","Nuwara Eliya" ,"0522 222 121" , R.drawable.fire))
        mList.add(LanguageData("Fire and Rescue","Matara" ,"0412 236 000" , R.drawable.fire))
        mList.add(LanguageData("Fire Service Department","Kandy" ,"0812 204 844" , R.drawable.fire))
        mList.add(LanguageData("Fire Service Department","Gampaha" ,"0332 224 444" , R.drawable.fire))
        mList.add(LanguageData("Municipal Fire Brigade","Kurunegala" ,"0372 222 270" , R.drawable.fire))
        mList.add(LanguageData("Fire Brigade","Polonnaruwa" ,"0272 226 668" , R.drawable.fire))




    }
}