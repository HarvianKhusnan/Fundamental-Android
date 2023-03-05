package com.example.myfragmentactivity

import android.os.Bundle
import android.provider.CalendarContract.Instances
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentContainer

class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstances: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blankh, container, false)
        /*
        pada kode ini layout interface didefinisikan dan ditranformasikan dari layout
        berupa xml kedalam objek view dengan inflate()

        Inflater.inflate() merupakan objek yang berfungsi mengubah layout xmlke dalam bentuk
        objek viewgroup atau widget, pada fungsi diini inflate menampilkan layout dari fragmnet
        dimana layout yang ditampilkan adalah fragment_Home
         */
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory:Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
        /*
        kode ini akan bekerja setelah metode onCreateView(), disini bisa menggunakan
        inisialisasi view dan mengatur action-nya, pada pemanggilan findViewById()
        tidak dapat dilakukan seperti di Activity perlu menambahkan variabel View terlebih dahulu
         */
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
                /*
                Berbeda dengan Activity yang memanfaatkan supportFragmentManager
                fragment menggunakan parentFragmentManager, pada kode ini kita menggunakan
                method replace() dan bukan add()
                 */
                addToBackStack(null)
                commit()
            }
        }

    }

}