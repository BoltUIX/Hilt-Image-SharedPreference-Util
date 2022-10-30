package com.boltuix.mvvm.view

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.boltuix.mvvm.utils.PicassoUtil
import com.boltuix.mvvm.databinding.FragmentFirstBinding
import com.boltuix.mvvm.utils.SpUtil
import com.boltuix.mvvm.viewmodel.FirstFragmentViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    @Inject
    lateinit var picassoUtil: PicassoUtil

    @Inject
    lateinit var sp: SpUtil

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val viewModel : FirstFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sp.save("user_name","bolt uix")
        sp.save("user_id",123)
        sp.save("boolean_once",false)

        Log.d("test01","${ sp.getValueString("user_name")}")


        binding.btnRefresh.setOnClickListener {
            viewModel.fetchNewImageUrl()
        }

        viewModel.imageUrlLiveData.observe(viewLifecycleOwner) { imageUrl ->
            picassoUtil.loadImage(imageUrl, binding.imageView)

          /*  val picasso =  Picasso.get()
            picasso.load(imageUrl).into(binding.imageView)*/
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}