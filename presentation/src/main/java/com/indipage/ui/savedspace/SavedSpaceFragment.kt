package com.indipage.ui.savedspace

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.view.UiState
import com.indipage.presentation.R
import com.indipage.presentation.databinding.FragmentSavedSpaceBinding
import com.indipage.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SavedSpaceFragment :
    BindingFragment<FragmentSavedSpaceBinding>(R.layout.fragment_saved_space) {

    private lateinit var adapter: SavedSpaceAdapter
    private val viewModel by viewModels<SavedSpaceViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SavedSpaceAdapter( onMoveToSpaceDetailClick = { space, positon ->
            Timber.tag("testClick").d("$space,$positon")
            viewModel.openSpaceDetail(space.id)
        })
        binding.rvSavedSpace.adapter = adapter
        viewModel.getSavedSpaces()
        getCollectData()
        setNavigation()
        moveToSpaceDetail()
    }

    private fun moveToSpaceDetail() {
        viewModel.openSpaceEvent.observe(viewLifecycleOwner, EventObserver {
            Timber.d("test $it")
            findNavController().navigate(
                R.id.action_navigation_saved_space_to_navigation_space_detail, bundleOf(
                    "spaceId" to it
                )
            )
        })
    }

    private fun setNavigation() {
        binding.tbSavedSpace.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getCollectData() {
        viewModel.savedSpaces.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    adapter.submitList(it.data)
                    binding.coSavedSpaceEmptyView.visibility =
                        if (it.data.isEmpty()) View.VISIBLE else View.GONE
                }
                else -> {}
            }
        }.launchIn(lifecycleScope)
    }
}