package com.objectone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.objectone.R
import com.objectone.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_enter_phone.*

class EnterPhoneFragment : Fragment() {

    companion object {
        fun newInstance(): EnterPhoneFragment {
            return EnterPhoneFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_phone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        enter_phone_text_input_edit_text.requestFocus()
        (activity as MainActivity).showKeyboard(enter_phone_text_input_edit_text)
    }
}