package com.willychuang.access

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.willychuang.access.data.User
import com.willychuang.access.databinding.ItemUserBinding
import com.willychuang.access.utils.AvatarOutlineProvider
import com.willychuang.access.utils.Logger

class UserListAdapter() :
    ListAdapter<User, RecyclerView.ViewHolder>(DiffCallback) {

    class UserViewHolder(
        private var binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(user: User) {

            val outlineProvider = AvatarOutlineProvider()
            binding.outlineProvider = outlineProvider
            binding.user = user
            binding.layoutCardUser.setOnClickListener {
                Navigation.createNavigateOnClickListener(
                    NavigationDirections.NavigateToUserDetail(
                        user.login
                    )
                ).onClick(binding.layoutCardUser)
            }

            binding.executePendingBindings()
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.login == newItem.login
        }

        private const val ITEM_VIEW_TYPE_LEADER = 0x01
        private const val ITEM_VIEW_TYPE_USER = 0x02
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_USER -> UserViewHolder(
                ItemUserBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> {
                holder.bind((getItem(position) as User))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return ITEM_VIEW_TYPE_USER
    }


}