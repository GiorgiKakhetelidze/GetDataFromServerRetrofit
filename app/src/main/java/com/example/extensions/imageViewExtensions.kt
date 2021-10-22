package com.example.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.setImage(img : String){
    Glide.with(context).load(img).into(this)
}

