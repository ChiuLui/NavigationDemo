package com.chiului.navigationdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navControllerActivity: NavController
    lateinit var navControllerFragment: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 获取 ViewModel
        val model: MyViewModel by viewModels()

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

    }

    override fun onResume() {
        super.onResume()

        navControllerActivity = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navControllerActivity.graph)

        // 将 toolbar 与 Navigation UI 绑定
        tool_bar.setupWithNavController(navControllerActivity, appBarConfiguration)

        // 导航切换的监听
        navControllerActivity.addOnDestinationChangedListener { _, destination, _ ->

        }


        // 如需向默认操作栏添加导航支持(如果没有默认导航栏会闪退)
//        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    /**
     * 将 BottomNavigationBar 与 Navigation UI 绑定
     */
    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(R.navigation.nav_graph, R.navigation.nav_leader_board, R.navigation.nav_settings)

        // Setup the bottom navigation view with a list of navigation graphs
        bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )
    }

    // 如需向默认操作栏添加导航回退支持(如果没有默认导航栏会闪退)
//    override fun onSupportNavigateUp(): Boolean {
//        // 将 toolbar 的回退 与 Navigation UI 的回退逻辑绑定
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }

}