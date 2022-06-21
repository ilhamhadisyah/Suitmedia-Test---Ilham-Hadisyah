package com.ilhamhadisyah.suitmediatest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilhamhadisyah.suitmediatest.AppBase
import com.ilhamhadisyah.suitmediatest.R
import com.ilhamhadisyah.suitmediatest.data.model.GuestModel
import com.ilhamhadisyah.suitmediatest.data.repositories.Resources
import com.ilhamhadisyah.suitmediatest.databinding.ActivityScreen4Binding
import com.ilhamhadisyah.suitmediatest.di.ViewModelFactory
import com.ilhamhadisyah.suitmediatest.ui.recyclerviewadapter.GuestAdapter
import com.ilhamhadisyah.suitmediatest.utils.RecyclerViewItemSelected
import com.ilhamhadisyah.suitmediatest.viewmodel.GuestViewModel
import javax.inject.Inject
import kotlin.reflect.cast

class Screen4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityScreen4Binding
    private lateinit var adapter: GuestAdapter
    private var initPage = 1

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: GuestViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as AppBase).components.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityScreen4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_back)



        adapter = GuestAdapter()

        with(binding) {
            rvGuest.layoutManager =
                GridLayoutManager(this@Screen4Activity, 2, GridLayoutManager.VERTICAL, false)
            adapter.initialize(object : RecyclerViewItemSelected {
                override fun onItemSelected(model: GuestModel) {
                    intent.putExtra("GUEST", model)
                    setResult(200, intent)
                    finish()
                }

            })
            rvGuest.adapter = adapter
        }

        binding.rvGuest.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
                val gridLayoutManager = GridLayoutManager::class.cast(recyclerView.layoutManager)
                val itemTotalList = gridLayoutManager.itemCount
                val lastVisible = gridLayoutManager.findLastVisibleItemPosition()

                val endPosition = lastVisible + 5 >= itemTotalList
                if (itemTotalList > 0 && endPosition) {
                    initPage++
                    loadData()
                }

            }
        })

        binding.swipeLayout.setOnRefreshListener { loadData() }

        loadData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadData() {
        viewModel.getGuest(initPage).observe(this) { guests ->
            if (guests != null) {
                when (guests) {
                    is Resources.Success -> {
//                        initPage++
                        binding.swipeLayout.isRefreshing = false
                        adapter.submitList(guests.data as PagedList<GuestModel>)

                    }
                    is Resources.Loading -> {
                        binding.swipeLayout.isRefreshing = true
                    }
                    is Resources.Error -> {}
                }
            }
        }
    }
}

