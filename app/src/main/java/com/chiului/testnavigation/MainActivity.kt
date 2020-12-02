package com.chiului.testnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MyViewModel by viewModels()

    }

    override fun onResume() {
        super.onResume()

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // 将 toolbar 与 Navigation UI 绑定
        tool_bar.setupWithNavController(navController, appBarConfiguration)

        // TODO: 12/1/20 主页不显示回退按钮还有问题
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // 主页不显示回退按钮
//            var id = destination.id
//            var actionId = R.id.action_secondFragment_to_thirdFragment
//            if(destination.id == R.id.action_secondFragment_to_thirdFragment) {
//                tool_bar.visibility = View.GONE
//            } else {
//                tool_bar.visibility = View.VISIBLE
//            }

        }

        // 如需向默认操作栏添加导航支持(如果没有默认导航栏会闪退)
//        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    // 如需向默认操作栏添加导航回退支持(如果没有默认导航栏会闪退)
//    override fun onSupportNavigateUp(): Boolean {
//        // 将 toolbar 的回退 与 Navigation UI 的回退逻辑绑定
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

}