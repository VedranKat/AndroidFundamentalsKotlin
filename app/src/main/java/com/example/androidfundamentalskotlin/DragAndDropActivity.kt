package com.example.androidfundamentalskotlin

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.androidfundamentalskotlin.databinding.ActivityDragAndDropBinding

class DragAndDropActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDragAndDropBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDragAndDropBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llTop.setOnDragListener(dragListener)
        binding.llBottom.setOnDragListener(dragListener)

        binding.dragView.setOnLongClickListener(){
            val clipText = "This is our ClipData text"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText,mimeTypes,item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
    }

    val dragListener = View.OnDragListener { v, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                v.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                v.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                v.invalidate()

                val vv = event.localState as View
                val owner = vv.parent as ViewGroup
                owner.removeView(vv)
                val destination = v as LinearLayout
                destination.addView(vv)
                vv.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED ->{
                v.invalidate()
                true
            }
            else -> false
        }
    }
}