package com.ruchanokal.haberler.fragments

import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ruchanokal.haberler.databinding.FragmentDetayBinding
import com.ruchanokal.haberler.model.News


class DetayFragment : Fragment() {

    private lateinit var paramsNotFullscreen : RelativeLayout.LayoutParams

    private var binding: FragmentDetayBinding? = null
    private lateinit var news: News
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textArray = arrayOf(binding?.textDetay1,
            binding?.textDetay2,
            binding?.textDetay3,
            binding?.textDetay4,
            binding?.textDetay5,
            binding?.textDetay6,
            binding?.textDetay7,
            binding?.textDetay8,
            binding?.textDetay9,
            binding?.textDetay10,
            binding?.textDetay11,
            binding?.textDetay12,
            binding?.textDetay13,
            binding?.textDetay14,
            binding?.textDetay15,
            binding?.textDetay16,
            binding?.textDetay17,
            binding?.textDetay18,
            binding?.textDetay19,
            binding?.textDetay20,
            binding?.textDetay21,
            binding?.textDetay22,
            binding?.textDetay23,
            binding?.textDetay24,
            binding?.textDetay25,
            binding?.textDetay26,
            binding?.textDetay27,
            binding?.textDetay28,
            binding?.textDetay29,
            binding?.textDetay30,
            binding?.textDetay31,
            binding?.textDetay32

        )

        for (x in 1..textArray.size) {

            textArray[x-1]?.visibility = View.GONE

        }

        val araBaslikTextArray = arrayOf(binding?.baslikDetay1,
            binding?.baslikDetay2,
            binding?.baslikDetay3,
            binding?.baslikDetay4,
            binding?.baslikDetay5,
            binding?.baslikDetay6,
            binding?.baslikDetay7,
            binding?.baslikDetay8,
            binding?.baslikDetay9,
            binding?.baslikDetay10,
            binding?.baslikDetay11,
            binding?.baslikDetay12,
            binding?.baslikDetay13,
            binding?.baslikDetay14,
            binding?.baslikDetay15,
            binding?.baslikDetay16,
            binding?.baslikDetay17,
            binding?.baslikDetay18,
            binding?.baslikDetay19,
            binding?.baslikDetay20,
            binding?.baslikDetay21,
            binding?.baslikDetay22,
            binding?.baslikDetay23,
            binding?.baslikDetay24,
            binding?.baslikDetay25,
            binding?.baslikDetay26,
            binding?.baslikDetay27,
            binding?.baslikDetay28,
            binding?.baslikDetay29,
            binding?.baslikDetay30,
            binding?.baslikDetay31,
            binding?.baslikDetay32
        )

        for (x in 1..araBaslikTextArray.size) {

            araBaslikTextArray[x-1]?.visibility = View.GONE

        }

        val imageArray = arrayOf(binding?.imageViewDetayAraFoto1,
            binding?.imageViewDetayAraFoto2,
            binding?.imageViewDetayAraFoto3,
            binding?.imageViewDetayAraFoto4,
            binding?.imageViewDetayAraFoto5,
            binding?.imageViewDetayAraFoto6,
            binding?.imageViewDetayAraFoto7,
            binding?.imageViewDetayAraFoto8,
            binding?.imageViewDetayAraFoto9,
            binding?.imageViewDetayAraFoto10,
            binding?.imageViewDetayAraFoto11,
            binding?.imageViewDetayAraFoto12,
            binding?.imageViewDetayAraFoto13,
            binding?.imageViewDetayAraFoto14,
            binding?.imageViewDetayAraFoto15,
            binding?.imageViewDetayAraFoto16,
            binding?.imageViewDetayAraFoto17,
            binding?.imageViewDetayAraFoto18,
            binding?.imageViewDetayAraFoto19,
            binding?.imageViewDetayAraFoto20,
            binding?.imageViewDetayAraFoto21,
            binding?.imageViewDetayAraFoto22,
            binding?.imageViewDetayAraFoto23,
            binding?.imageViewDetayAraFoto24,
            binding?.imageViewDetayAraFoto25,
            binding?.imageViewDetayAraFoto26,
            binding?.imageViewDetayAraFoto27,
            binding?.imageViewDetayAraFoto28,
            binding?.imageViewDetayAraFoto29,
            binding?.imageViewDetayAraFoto30,
            binding?.imageViewDetayAraFoto31,
            binding?.imageViewDetayAraFoto32
        )

        for (x in 1..imageArray.size) {

            imageArray[x-1]?.visibility = View.GONE

        }


        arguments?.let {

            news = DetayFragmentArgs.fromBundle(it).example

        }

        if (!news.videoUrl.equals("")){

            binding?.videoWeb?.setVideoURI(Uri.parse(news.videoUrl))
            binding?.videoWeb?.setMediaController(MediaController(context))
            binding?.videoWeb?.requestFocus()


            binding?.playTusu?.setOnClickListener {

                binding?.playTusu?.visibility = View.GONE
                binding?.videoWeb?.start()

            }

            binding?.videoWeb?.setOnCompletionListener {

                binding?.playTusu?.visibility = View.VISIBLE

            }



        } else {

            binding?.videoWeb?.visibility = View.GONE
            binding?.playTusu?.visibility = View.GONE
            binding?.imageViewDetayAnaFoto?.visibility = View.VISIBLE
            context?.let { binding?.imageViewDetayAnaFoto?.let { it1 ->
                Glide.with(it).load(news.imageUrl).into(
                    it1)
            } }

        }



        binding?.anaBaslikDetayText?.text = news.title
        binding?.spotDetayText?.text = news.spot

        if ( !news.category.equals("0")){

            binding?.kategoriTextDetay?.text = news.category
            val newPublishDate = news.publishDate
            binding?.tarihTextDetay?.text = newPublishDate.subSequence(0,newPublishDate.length - 5)
        } else {

            binding?.tarihTextDetay?.visibility = View.GONE
            binding?.kategoriTextDetay?.visibility = View.GONE

        }


        for ( a in 1..news.body.size){



        news.body[a-1].p.let {

            if ( news.body[a-1].p != null){

                textArray[a-1]?.visibility = View.VISIBLE
                textArray[a-1]?.text = news.body[a-1].p

            }

        }

        news.body[a-1].h3.let {

            if ( news.body[a-1].h3 != null){

                araBaslikTextArray[a-1]?.visibility = View.VISIBLE
                araBaslikTextArray[a-1]?.text = news.body[a-1].h3
            }

        }



        news.body[a-1].image.let {

            if ( news.body[a-1].image != null){

                imageArray[a-1]?.visibility = View.VISIBLE
                context?.let { it -> imageArray[a-1]?.let { it1 ->
                    Glide.with(it).load(news.body[a-1].image).into(
                        it1
                    )
                } }


            }



        }



        }

        binding?.progressBar?.visibility = View.GONE

        val newConfig : Configuration = requireActivity().resources.configuration

        onConfigurationChanged(newConfig)


    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)


        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {


            binding?.cardViewDetay?.visibility = View.GONE


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                requireActivity().window.decorView.windowInsetsController!!.hide(android.view.WindowInsets.Type.statusBars())

            } else {

                requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

            }

            paramsNotFullscreen = binding?.videoWeb?.getLayoutParams() as RelativeLayout.LayoutParams
            val params: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(paramsNotFullscreen)
            params.setMargins(0, 0, 0, 0)
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.addRule(RelativeLayout.CENTER_IN_PARENT)
            binding?.videoWeb?.setLayoutParams(params)


        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                requireActivity().window.decorView.windowInsetsController!!.show(android.view.WindowInsets.Type.statusBars())

            } else {

                requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

            }


            binding?.cardViewDetay?.visibility = View.VISIBLE


            val scale = requireContext().resources.displayMetrics.density
            val pixels = (330 * scale + 0.5f)

            paramsNotFullscreen = binding?.videoWeb?.getLayoutParams() as RelativeLayout.LayoutParams

            val params: RelativeLayout.LayoutParams =
                RelativeLayout.LayoutParams(paramsNotFullscreen)
            params.setMargins(0, 0, 0, 0)
            params.height = pixels.toInt()
            params.width = ViewGroup.LayoutParams.MATCH_PARENT
            params.addRule(RelativeLayout.CENTER_IN_PARENT)
            binding?.videoWeb?.setLayoutParams(paramsNotFullscreen)
        }





    }

}