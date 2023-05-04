package src

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.developer_ability_test.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val TAG : String = "로그"
    }

    lateinit var MyNumberViewModel : MyNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        MyNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG,"MainActivity - 라이드 데이터 값 변경 : $it")

            plus_btn.setOnClickListener(this)
        })
    }

    // 클릭시 이벤트
    override fun onClick(p0: View?) {

    }
}