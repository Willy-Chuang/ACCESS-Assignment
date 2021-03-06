package com.willychuang.access

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.willychuang.access.databinding.FragmentUserDetailBinding
import com.willychuang.access.network.LoadApiStatus
import com.willychuang.access.utils.BigAvatarOutlineProvider
import com.willychuang.access.utils.Logger
import com.willychuang.access.utils.getVmFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UserDetailFragment : Fragment() {

    lateinit var binding: FragmentUserDetailBinding

    private val viewModel by viewModels<UserDetailViewModel> {
        getVmFactory(
            UserDetailFragmentArgs.fromBundle(
                requireArguments()
            ).login
        )
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.imageClose.setOnClickListener {
            findNavController().navigate(NavigationDirections.navigateToUserList())
        }
        binding.outlineProvider = BigAvatarOutlineProvider()

        viewModel.status.observe(viewLifecycleOwner, Observer {
            //Handle network respond state
            if(it == LoadApiStatus.LOADING) {
                binding.progress.visibility = View.VISIBLE
            } else {
                binding.progress.visibility = View.GONE
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            //Can build alert to show user the relevant exception
        })
        return binding.root
    }

}