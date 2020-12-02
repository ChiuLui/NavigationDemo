package com.chiului.testnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_fourth.*

/**
 * 完善信息
 * @author 神经大条蕾弟
 * @date   2020/11/27 9:13 PM
 */
class FourthFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {

            // 使用 Safe Args 传递参数
            var action =
                FourthFragmentDirections.actionFourthFragmentToThirdFragment("已完善信息")
            view.findNavController().navigate(action)

            // 使用 Bundle 对象在目的地之间传递参数
//            var bundle = bundleOf("info" to "已完善信息")
//            view.findNavController().navigate(R.id.action_fourthFragment_to_thirdFragment, bundle)
        }
    }
}