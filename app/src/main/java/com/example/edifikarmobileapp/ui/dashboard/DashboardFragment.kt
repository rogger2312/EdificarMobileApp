package com.example.edifikarmobileapp.ui.dashboard

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.edifikarmobileapp.R
import com.example.edifikarmobileapp.adapter.ProyectAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.lang.IllegalArgumentException

@Suppress("DEPRECATION")
class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var pref: PreferenceManager? = null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        setupObservers()
        getListData()
        //val textView: TextView = root.findViewById(R.id.text_dashboard)
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        return root
    }
    fun getListData() {
            dashboardViewModel.getObservacionesAsignadas()

    }
    fun setupObservers() {

        dashboardViewModel.responseLiveData.observe(this, Observer {
            it?.let {
                if (it.isNotEmpty()) {
                    rvProperties.adapter = ProyectAdapter(it)
                }
            }
        })
    }

}
