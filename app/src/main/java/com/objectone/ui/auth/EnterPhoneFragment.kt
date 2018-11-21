package com.objectone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.objectone.R

class EnterPhoneFragment : Fragment() {

    companion object {
        fun newInstance(): EnterPhoneFragment {
            return EnterPhoneFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_phone, container, false)
    }
}