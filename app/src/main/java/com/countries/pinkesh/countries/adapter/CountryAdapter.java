package com.countries.pinkesh.countries.adapter;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.request.RequestOptions;

import com.countries.pinkesh.countries.R;
import com.countries.pinkesh.countries.models.BaseCountry;

import com.countries.pinkesh.countries.svg.SvgDecoder;
import com.countries.pinkesh.countries.svg.SvgDrawableTranscoder;
import com.countries.pinkesh.countries.svg.SvgSoftwareLayerSetter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {


    Context ctx;
    List<BaseCountry> baseCountriesList;
    private List<BaseCountry> baseCountryListFiltered;
    private CountryAdapterListener listener;
    private RequestBuilder<PictureDrawable> requestBuilder;

    public CountryAdapter(Context ctx, List<BaseCountry> baseCountriesList, CountryAdapterListener listener) {
        this.ctx = ctx;
        this.baseCountriesList = baseCountriesList;
        this.listener = listener;
        this.baseCountryListFiltered = baseCountriesList;

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_itemview, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(item);

        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        BaseCountry baseCountry = baseCountryListFiltered.get(position);
        //Glide.with(ctx).load(baseCountry.getFlag()).into(holder.imageViewFlag);
        // Picasso.with(ctx).load(baseCountry.getFlag()).resize(120,60).into(holder.imageViewFlag);
        holder.textViewName.setText(baseCountry.getName());
        requestBuilder = Glide.with(ctx)
                .as(PictureDrawable.class).apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)).transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
        Uri uri = Uri.parse(baseCountry.getFlag());
        requestBuilder.load(uri).into(holder.imageViewFlag);

    }

    @Override
    public int getItemCount() {
        return baseCountryListFiltered.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_name)
        TextView textViewName;
        @BindView(R.id.imageView_flag)
        ImageView imageViewFlag;
        @BindView(R.id.LinearLayout)
        LinearLayout linearLayout;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected Country in callback
                    listener.onCountrySelected(baseCountryListFiltered.get(getAdapterPosition()));
                }
            });
        }


    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    baseCountryListFiltered = baseCountriesList;
                } else {
                    List<BaseCountry> filteredList = new ArrayList<>();
                    for (BaseCountry row : baseCountriesList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    baseCountryListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = baseCountryListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                baseCountryListFiltered = (ArrayList<BaseCountry>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface CountryAdapterListener {
        void onCountrySelected(BaseCountry baseCountry);
    }


}

