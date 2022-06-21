package com.ilhamhadisyah.suitmediatest.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilhamhadisyah.suitmediatest.AppBase
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.databinding.FragmentEventListBinding
import com.ilhamhadisyah.suitmediatest.di.ViewModelFactory
import com.ilhamhadisyah.suitmediatest.ui.recyclerviewadapter.EventAdapter
import com.ilhamhadisyah.suitmediatest.utils.EventCardListener
import com.ilhamhadisyah.suitmediatest.viewmodel.EventViewModel
import javax.inject.Inject


class EventListFragment : Fragment() {

    private var _binding: FragmentEventListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: EventViewModel by viewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEventListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as AppBase).components.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvEvents.layoutManager?.removeAllViews()
        val adapter = EventAdapter()
        binding.rvEvents.layoutManager = LinearLayoutManager(context)
        binding.rvEvents.adapter = adapter
        if (activity != null) {
            viewModel.getEventData().observe(viewLifecycleOwner) { eventData ->
                if (eventData != null) {
                    adapter.setData(eventData)
                    adapter.notifyDataSetChanged()

                }
            }

            adapter.initialize(object : EventCardListener {
                override fun onCardSelected(model: EventModel) {
                    val parentActivity = activity
                    val intent = parentActivity?.intent?.putExtra("EVENT", model)
                    parentActivity?.setResult(201, intent)
                    parentActivity?.finish()
                }

            })

        }
    }

    override fun onStop() {
        super.onStop()
        binding.rvEvents.layoutManager?.removeAllViews()
    }

    override fun onResume() {
        super.onResume()
        binding.rvEvents.layoutManager?.removeAllViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.rvEvents.layoutManager?.removeAllViews()
    }


}