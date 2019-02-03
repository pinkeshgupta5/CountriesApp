package com.countries.pinkesh.countries;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.countries.pinkesh.countries.models.BaseCountry;
import com.countries.pinkesh.countries.room.CountryDatabase;
import com.countries.pinkesh.countries.svg.SvgSoftwareLayerSetter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountryDetailsActivity extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView ImageViewFlag;
    @BindView(R.id.textView_name)
    TextView textView_Name;
    @BindView(R.id.textView_capital)
    TextView textView_Capital;
    @BindView(R.id.textView_region)
    TextView textView_Region;
    @BindView(R.id.textView_subregion)
    TextView textView_Subregion;
    @BindView(R.id.textView_callincodes)
    TextView textView_CallinCodes;
    @BindView(R.id.textView_curcode)
    TextView textView_Curcode;
    @BindView(R.id.textView_curname)
    TextView textView_Curname;
    @BindView(R.id.textView_cursymbol)
    TextView textView_Cursymbol;
    @BindView(R.id.textView_Langiso1)
    TextView textView_LAngsio1;
    @BindView(R.id.textView_Langiso2)
    TextView textView_Langsio2;
    @BindView(R.id.textView_LangName)
    TextView textView_LangName;
    @BindView(R.id.textView_LangNative)
    TextView textView_LangNative;
    @BindView(R.id.textView_TimeZones)
    TextView textView_Timezones;

    @BindView(R.id.button_save)
    Button Button_Save;


    private CountryDatabase countryDatabase;
    private BaseCountry baseCountry;
    private RequestBuilder<PictureDrawable> requestBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        baseCountry = (BaseCountry) extras.getSerializable("countrydata");
        countryDatabase = CountryDatabase.getInstance(this);
       //countryDatabase = Room.databaseBuilder(this,CountryDatabase.class,"database").build();
        //Nameemployee
        textView_Name.setText(baseCountry.getName());
        //Capital
        textView_Capital.setText(baseCountry.getCapital());
        //Region
        textView_Region.setText(baseCountry.getRegion());
        //Subregion
        textView_Subregion.setText(baseCountry.getSubregion());
        //CcallingCodes
        textView_CallinCodes.setText(baseCountry.getCallingCodes().get(0).toString());
        //Currencies
        textView_Curcode.setText(baseCountry.getCurrencies().get(0).getCode());
        textView_Curname.setText(baseCountry.getCurrencies().get(0).getName());
        textView_Cursymbol.setText(baseCountry.getCurrencies().get(0).getSymbol());
        //Languages
        textView_LAngsio1.setText(baseCountry.getLanguages().get(0).getIso639_1());
        textView_Langsio2.setText(baseCountry.getLanguages().get(0).getIso639_2());
        textView_LangName.setText(baseCountry.getLanguages().get(0).getName());
        textView_LangNative.setText(baseCountry.getLanguages().get(0).getNativeName());
        //TimeZones
        textView_Timezones.setText(baseCountry.getTimezones().get(0).toString());


        requestBuilder = Glide.with(this)
                .as(PictureDrawable.class).apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)).transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
        Uri uri = Uri.parse(baseCountry.getFlag());
        requestBuilder.load(uri).into(ImageViewFlag);

        Button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {
                        BaseCountry baseCountryDatainsert = new BaseCountry(baseCountry.getName(),baseCountry.getFlag());
                        countryDatabase.getcountryDao().insertAll(baseCountryDatainsert);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(CountryDetailsActivity.this, "DataInserted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }


                });


            }

        });
    }

}