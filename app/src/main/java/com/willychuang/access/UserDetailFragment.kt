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
import com.willychuang.access.utils.getVmFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class UserDetailFragment : Fragment() {

    lateinit var binding: FragmentUserDetailBinding

    private val viewModel by viewModels<UserDetailViewModel> {
        getVmFactory(
//            UserDetailFragmentArgs.fromBundle(
//                requireArguments()
//            ).login
        )
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}