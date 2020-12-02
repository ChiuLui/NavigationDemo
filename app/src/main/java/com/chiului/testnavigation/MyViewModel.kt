package com.chiului.testnavigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Activity 的 ViewModel$
 * @author    神经大条蕾弟
 * @date      2020/12/01 15:38
 */
class MyViewModel: ViewModel() {

    private val isSplash: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(true)
    }

    fun getIsSplash(): MutableLiveData<Boolean> {
        return isSplash
    }

}