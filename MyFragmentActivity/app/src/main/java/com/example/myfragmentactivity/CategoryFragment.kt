package com.example.myfragmentactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class CategoryFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory:Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View){
        if(v.id == R.id.btn_detail_category){
            val mDetailCategoryFragment = DetailCategoryFragment()
            val mBundle = Bundle() // digunakan untuk mengirimkan data antar fragment
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle") // objek data yang ingin dikirimkan
            val description = "Kategori ini akan berisi produk-produk lifestyle" // setter untuk mengirim data
            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description // setter untuk mengirim data
            val mFragmentManager = parentFragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }


        }
    }
}