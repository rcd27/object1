package com.objectone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.objectone.R
import kotlinx.android.synthetic.main.fragment_auth_flow.*

class AuthFlowFragment : Fragment() {

    companion object {
        fun newInstance(): AuthFlowFragment {
            return AuthFlowFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_auth_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth_view_pager.adapter = AuthPagerAdapter(childFragmentManager)
    }
}

class AuthPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return EnterPhoneFragment.newInstance()
            1 -> return EnterCodeFragment.newInstance()
        }

        // FIXME: this is not necessary and there is workaround
        throw IllegalArgumentException("No Fragment for position: $position")
    }
}
