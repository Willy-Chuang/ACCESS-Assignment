package com.willychuang.access

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.willychuang.access.databinding.FragmentUserListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class UserListFragment : Fragment() {

    lateinit var binding: FragmentUserListBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)


        return binding.root
    }
}