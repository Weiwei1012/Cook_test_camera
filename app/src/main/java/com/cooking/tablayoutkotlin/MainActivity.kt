package com.cooking.tablayoutkotlin

import android.content.ContentValues
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.cooking.tablayoutkotlin.adapters.Permissions
import com.cooking.tablayoutkotlin.fragments.CameraFragment
import com.cooking.tablayoutkotlin.fragments.FavoritesFragment
import com.cooking.tablayoutkotlin.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(ContentValues.TAG, "onCreate: started.")

        if(checkPermissionArray(Permissions.PERMISSIONS)){
            val homeFragment = HomeFragment()
            val cameraFragment = CameraFragment()
            val favoritesFragment = FavoritesFragment()

            setCurrentFragment(homeFragment)

            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId){
                    R.id.nav_home -> setCurrentFragment(homeFragment)
                    R.id.nav_camera -> setCurrentFragment(cameraFragment)
                    R.id.nav_favorites -> setCurrentFragment(favoritesFragment)
                }
                true
            }
        }else{
            verifyPermissions(Permissions.PERMISSIONS)
        }

    }

    private fun verifyPermissions(permissions: Array<String>) {
        Log.d(ContentValues.TAG, "verifyPermissions : verifying permissions.")
        ActivityCompat.requestPermissions(
                this@MainActivity, permissions, VERIFY_PERMISSIONS_REQUEST
        )
    }

    private fun checkPermissionArray(permissions: Array<String>): Boolean {
        Log.d(ContentValues.TAG, "checkPermissionsArray: checking permissions array.")
        for (i in permissions.indices) {
            val check = permissions[i]
            if (!checkPermissions(check)) {
                return false
            }
        }
        return true
    }

    fun checkPermissions(permission: String): Boolean {
        Log.d(ContentValues.TAG, "checkPermissions: checking permissions $permission")
        val permissionRequest = ActivityCompat.checkSelfPermission(this@MainActivity, permission)
        return if (permissionRequest != PackageManager.PERMISSION_GRANTED) {
            Log.d(ContentValues.TAG, "checkPermissions: \n Permission wasn't granted for: $permission")
            false
        } else {
            Log.d(ContentValues.TAG, "checkPermissions: \n Permission was granted for: $permission")
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    companion object {
        private const val TAG = "CameraActivity"
        private const val VERIFY_PERMISSIONS_REQUEST = 1
    }

}