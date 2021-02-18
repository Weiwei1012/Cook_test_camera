package com.cooking.tablayoutkotlin.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.cooking.tablayoutkotlin.MainActivity
import com.cooking.tablayoutkotlin.R
import com.cooking.tablayoutkotlin.adapters.Permissions.CAMERA_PERMISSIONS

class  CameraFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_camera, container, false)
        val Launch_Camera_btn = view.findViewById<View>(R.id.Launch_Camera_btn) as Button
        Launch_Camera_btn.setOnClickListener {
            if ((activity as MainActivity?)!!.checkPermissions(CAMERA_PERMISSIONS[0])) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
            } else {
                val intent = Intent(activity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE) {
            //final screen
        }
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 1114
    }
}