package com.chiului.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * 主页
 * @author 神经大条蕾弟
 * @date   2020/11/27 9:12 PM
 */
class ThirdFragment : Fragment() {

    // 获取传递过来的参数
    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this){
            // 关闭
            requireActivity().finish()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 显示传递过来的参数 使用 Safe Args
        var info = args.info

        // 显示传递过来的参数 使用 bundle
//        var info = arguments?.getString("info")

        text_info.text = info


        button.setOnClickListener {
            // 跳转完善信息页
            var action =
                ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
            view.findNavController().navigate(action)
        }

        button2.setOnClickListener {
            // 返回登录页
            var action =
                ThirdFragmentDirections.actionThirdFragmentToSecondFragment()
            view.findNavController().navigate(action)
        }
    }
}