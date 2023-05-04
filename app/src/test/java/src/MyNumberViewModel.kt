package src

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

//제트팩을 몰랐으니까 튜토리얼 정리!!! 유튜브 보면서 배웠음!!!
// 화면 전환 시 이를 자동적으로 변경해주는 역할을 하는거임 UI 가로일때 세로일때
// 안그려도 된다는소리

//뷰모델, 데이터의 변경
//뷰모델은 데이터의 변경 사항을 알려주는 라이브 데이터를 가지고 있다

enum class ActionType{
    PLUS, MINUS
}

class MyNumberViewModel : ViewModel() {

    companion object{
        const val TAG: String ="로그"
    }
    //뮤터블 라이브 데이터 - 수정 가능
    //라이브 데이터 - 수정 불가능

    //내부에서 설정하는 자료형은 뮤터블로 해야함!!!!! 그래야 사용자가 원하는 값으로 바꿀 수 있으니까
    private val _currenValue = MutableLiveData<Int>()

    //변경되지 않는 데이터를 가져 올때 이름을 _ 언더스코어 없이 설정
    //공개적으로 가져오는 변수는 private이 아닌 퍼블릭으로 외부에서도 접근가능하도록 설정
    //하지만 값을 직접 라이브데이터에 접근하지 않고 뷰모델을 통해 가져올 수 있도록 설정

    val currentValue: LiveData<Int>
        get() = _currenValue

    //초기값 설정
    init{
        Log.d(TAG, "생성자 호출")
        _currenValue.value = 0 //기본값 0으로 하는거임!!!
    }
    fun updateValue(actionType: ActionType, input: Int){
        when(actionType){
            ActionType.PLUS ->
                _currenValue.value = _currenValue.value?.plus(input)
            ActionType.MINUS ->
                _currenValue.value = _currenValue.value?.minus(input)
        }
    }



}