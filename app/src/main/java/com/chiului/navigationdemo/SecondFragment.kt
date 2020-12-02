package com.chiului.navigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * 登录页
 * @author 神经大条蕾弟
 * @date   2020/11/27 9:12 PM
 */
class SecondFragment : Fragment() {

    private val model: MyViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model.getIsSplash().observe(this, Observer {
            // 是否打开启动页
            if (it) {
                // 打开启动页
                var actionSecondToFirst =
                    SecondFragmentDirections.actionSecondFragmentToFirstFragment()
                findNavController().navigate(actionSecondToFirst)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            // 跳转主页
            var action =
                SecondFragmentDirections.actionSecondFragmentToThirdFragment("未完善信息")
            view.findNavController().navigate(action)
        }
    }
}