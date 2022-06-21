package com.ilhamhadisyah.suitmediatest.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.ilhamhadisyah.suitmediatest.R
import com.ilhamhadisyah.suitmediatest.data.model.EventDummy
import com.ilhamhadisyah.suitmediatest.data.model.EventModel
import com.ilhamhadisyah.suitmediatest.databinding.FragmentEventMapsBinding
import com.ilhamhadisyah.suitmediatest.utils.loadUrl


class EventMapsFragment : Fragment() {

    private var _binding: FragmentEventMapsBinding? = null
    private val binding get() = _binding!!

    private val mapData = EventDummy.getEventData()

    private fun bitmapFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)

        vectorDrawable!!.setBounds(
            3,
            3,
            70,
            85
        )

        val bitmap = Bitmap.createBitmap(
            70,
            85,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync { googleMap ->


            var previousMarker: Marker? = null

            googleMap.setOnMarkerClickListener { marker ->
                val title = marker.title


                if (previousMarker != null) {
                    previousMarker!!.setIcon(
                        bitmapFromVector(
                            requireContext(),
                            R.drawable.ic_marker_unselected
                        )
                    )
                }
                marker.setIcon(bitmapFromVector(requireContext(), R.drawable.ic_marker_selected))
                previousMarker = marker

                var event: EventModel? = null

                for (item in mapData) {
                    if (item.title.equals(title)) {
                        event = item
                    }
                }
                binding.cardDetail.apply {
                    eventTitle.text = event?.title
                    event?.imageUrl?.let { eventThumbnail.loadUrl(it) }
                    eventDesc.text = event?.description
                    eventHour.text = event?.time
                    eventDate.text = event?.date
                }

                binding.detailContainer.visibility = View.VISIBLE
                false
            }

            for (loc in mapData) {
                val latLng = LatLng(loc.lat!!, loc.lng!!)
                googleMap.addMarker(
                    MarkerOptions().position(latLng)
                        .icon(bitmapFromVector(requireContext(), R.drawable.ic_marker_unselected))
                        .title(loc.title)
                )
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f))
            }
        }
    }
}