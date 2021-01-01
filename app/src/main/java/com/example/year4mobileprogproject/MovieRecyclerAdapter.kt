package com.example.year4mobileprogproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.year4mobileprogproject.injection.androidTutoPost
import kotlinx.android.synthetic.main.layout_movie_list_item.view.*


class MovieRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<androidTutoPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){

            is MovieViewHolder -> {
                holder.bind(items.get(position))
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    fun submitList(movieList: List<androidTutoPost>){

        items = movieList
    }


   class MovieViewHolder constructor(
       itemView: View
   ): RecyclerView.ViewHolder(itemView) {

       val movieImage = itemView.movie_image
       val movieTitle  = itemView.movie_title
       val movieAuthor = itemView.movie_author

       fun bind(moviePost: androidTutoPost){

           movieTitle.setText(moviePost.title)
           movieAuthor.setText(moviePost.username)

           val requestOptions = RequestOptions()
               .placeholder(R.drawable.ic_launcher_background)
               .error(R.drawable.ic_launcher_background)

           Glide.with(itemView.context)
               .applyDefaultRequestOptions(requestOptions)
               .load(moviePost.image)
               .into(movieImage)


       }

   }

}