package wooyun.popupwindows

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import wooyun.popupwindows.tools.Tools
import wooyun.popupwindows.view.AddPopup


class MainActivity : AppCompatActivity() {
    private var lvTest: LinearLayout? = null
    private var tvTest: TextView? = null
    private var lvTest1: LinearLayout? = null
    private var lvTest2: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initView()
    }

    private fun init() {
        tvTest = findViewById<View>(R.id.tv_test) as TextView
        lvTest1 = findViewById(R.id.lv_test1)
        lvTest2 = findViewById(R.id.lv_test2)
    }


    private fun initView() {
        tvTest!!.setOnClickListener(View.OnClickListener {
            val createViewBitmap = lvTest?.let { Tools.createViewBitmap(it) }
            val fastBlur = createViewBitmap?.let { Tools.fastBlur(it, 0.5f, 50) }
            val addPop = AddPopup(this)
            addPop.show(tvTest!!)
            lvTest1!!.background = BitmapDrawable(fastBlur)
            addPop.tv_test1.setOnClickListener {
                addPop.tv_test1.isEnabled = false
                Toast.makeText(this@MainActivity, getString(R.string.tv_test), Toast.LENGTH_SHORT).show()
            }
            addPop.tv_test2.setOnClickListener {
                addPop.tv_test2.isEnabled = false
                Toast.makeText(this@MainActivity, getString(R.string.tv_test1), Toast.LENGTH_SHORT).show()
            }
        })
    }
}