package com.example.submissiongithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.submissiongithub.Adapter.SectionsPagerAdapter
import com.example.submissiongithub.ViewModel.DetailViewModel
import com.example.submissiongithub.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel


    companion object{
        const val USERNAME = "extra_username"

        private val TAB_TITLES = intArrayOf(
            R.string.follower_label,
            R.string.following_label
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.hide()
        setUser()


    }

    private fun setUser(){
        val usnm = intent.getStringExtra(USERNAME)
        val bundle = Bundle()
        bundle.putString(USERNAME, usnm)

        detailBinding.apply {
            val sectionsPagerAdapter = SectionsPagerAdapter(this@DetailActivity, bundle)
            viewPager.adapter = sectionsPagerAdapter
            TabLayoutMediator(tabLayout, viewPager){ tab, position ->
                tab.text = resources.getString(TAB_TITLES[position])
            }.attach()
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        viewModel.setDetailUser(usnm.toString())
        viewModel.getUserDetail().observe(this){
            if (it !=null){
                detailBinding.apply {
                    tvFullname.text = it.name
                    tvUsersUsernames.text = it.login
                    followersTotal.text = it.followers.toString()
                    followingTotal.text = it.following.toString()
                    Glide.with(detailBinding.root)
                        .load(it.avatar_url)
                        .circleCrop()
                        .into(detailUserPic)
                }
            }


        }
    }
}