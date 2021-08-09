package com.ruchanokal.haberler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ruchanokal.haberler.R
import com.ruchanokal.haberler.databinding.HaberRowBinding
import com.ruchanokal.haberler.fragments.AnaFragmentDirections
import com.ruchanokal.haberler.model.Example
import com.ruchanokal.haberler.model.News

class NewsAdapter(private val newsList: List<News>, val context : Context, val example: Example) : RecyclerView.Adapter<NewsAdapter.RowHolder>() {


    class RowHolder (val binding: HaberRowBinding) : RecyclerView.ViewHolder (binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {

        val binding : HaberRowBinding = HaberRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.binding.baslikText.text = newsList.get(position).title

        val requestOptions = RequestOptions.overrideOf(600,350)

        Glide.with(context)
            .load(newsList.get(position).imageUrl)
            .apply(requestOptions)
            .into(holder.binding.newsImageView)

        val newPublishDate = newsList.get(position).publishDate

        holder.binding.ozetText.text = newsList.get(position).spot

        if (!newsList.get(position).category.equals("0")){

            holder.binding.tarihText.text = newPublishDate.subSequence(0,newPublishDate.length - 5)
            holder.binding.kategoriText.text = newsList.get(position).category

        } else {

            holder.binding.tarihText.visibility = View.GONE
            holder.binding.kategoriText.visibility = View.GONE

        }



        holder.itemView.setOnClickListener {


            val action = AnaFragmentDirections.actionAnaFragmentToDetayFragment(newsList.get(position))
            Navigation.findNavController(it).navigate(action)


        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}