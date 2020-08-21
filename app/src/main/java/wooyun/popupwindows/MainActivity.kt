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
            val activityShot = Tools.activityShot(this)
            val fastBlur = Tools.fastBlur(activityShot, 0.5f, 50)

            val addPop = AddPopup(this)
            addPop.show(tvTest!!)

            lvTest2!!.setOnClickListener {
                lvTest1!!.visibility = View.VISIBLE
                lvTest2!!.visibility = View.GONE
            }
            lvTest1!!.visibility = View.GONE
            lvTest2!!.visibility = View.VISIBLE
            lvTest2!!.background = BitmapDrawable(fastBlur)

            addPop.tv_test1.setOnClickListener {
                Toast.makeText(this@MainActivity, getString(R.string.tv_test), Toast.LENGTH_SHORT).show()
            }
            addPop.tv_test2.setOnClickListener {
                Toast.makeText(this@MainActivity, getString(R.string.tv_test1), Toast.LENGTH_SHORT).show()
            }
        })
    }
}