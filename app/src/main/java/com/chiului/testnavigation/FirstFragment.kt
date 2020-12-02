package com.chiului.testnavigation

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * 启动页
 * @author 神经大条蕾弟
 * @date   2020/11/27 9:11 PM
 */
class FirstFragment : Fragment() {

    private val model: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Main) { // 在后台启动一个新的协程并继续≈
            // 延时
            startDelay()
            // 关闭启动页
            findNavController().navigateUp()
            // 修改是否显示启动页标识
            model.getIsSplash().setValue(false)
        }

    }

    private suspend fun startDelay() {
        withContext(Dispatchers.IO) {
            delay(1000L)
        }
    }
}