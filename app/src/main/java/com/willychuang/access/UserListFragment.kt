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
import com.willychuang.access.databinding.FragmentUserListBinding
import com.willychuang.access.network.LoadApiStatus
import com.willychuang.access.utils.getVmFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserListFragment : Fragment() {

    lateinit var binding: FragmentUserListBinding
    private val viewModel by viewModels<UserListViewModel> { getVmFactory() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val adapter = UserListAdapter()
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.recyclerUser.adapter = adapter

        viewModel.users.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

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