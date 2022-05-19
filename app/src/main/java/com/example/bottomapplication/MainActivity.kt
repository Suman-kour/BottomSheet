package com.example.bottomapplication

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog


class MainActivity : AppCompatActivity() {

        lateinit var btnShowBottomSheet: TextView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            btnShowBottomSheet = findViewById(R.id.text)
            btnShowBottomSheet.setOnClickListener {
                val dialog = BottomSheetDialog(this)
                val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
                val layout = view.findViewById<LinearLayout>(R.id.layout)
                val bottomSheetBehavior =BottomSheetBehavior.from(layout)
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN;
                view.minimumHeight =( (Resources.getSystem().displayMetrics.heightPixels)/1).toInt()

                bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
                    override fun onStateChanged(view: View, i: Int) {
                        if (BottomSheetBehavior.STATE_HIDDEN == i) {
                            dialog.dismiss()
                        }
                    }

                    override fun onSlide(view: View, v: Float) {
                    }
                })

                val btnClose = view.findViewById<ImageView>(R.id.idIVCourse)
                val text = view.findViewById<TextView>(R.id.text1)
                val text1 = view.findViewById<TextView>(R.id.text2)
                val text2 = view.findViewById<TextView>(R.id.text3)
                btnClose.setOnClickListener {
                    btnShowBottomSheet.text=text.text.toString()
                    dialog.dismiss()
                }
                text.setOnClickListener {
                    btnShowBottomSheet.text=text.text.toString()
                }
                text1.setOnClickListener {
                    btnShowBottomSheet.text=text1.text.toString()
                }
                text2.setOnClickListener {
                    btnShowBottomSheet.text=text2.text.toString()
                }
                dialog.setContentView(view)
                dialog.show()
            }
        }
}