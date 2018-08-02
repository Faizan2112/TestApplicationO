package com.example.root.testapplicationo.horizontal_catalogue_view.sample_catalog;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.root.testapplicationo.R;

class CatalogueView  extends LinearLayout{
    private Paint gradientPaint;
    private int[] currentGradient;

    private TextView weatherDescription;
    private TextView weatherTemperature;
    private ImageView weatherImage;
    private WebView wbProduct;

    private ArgbEvaluator evaluator;

    public CatalogueView(Context context) {
        super(context);
    }

    public CatalogueView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CatalogueView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CatalogueView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        evaluator = new ArgbEvaluator();

        gradientPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setWillNotDraw(false);

        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        inflate(getContext(), R.layout.view_forecast, this);

        weatherDescription = (TextView) findViewById(R.id.weather_description);
        weatherImage = (ImageView) findViewById(R.id.weather_image);
        weatherTemperature = (TextView) findViewById(R.id.weather_temperature);
    }
    public void onScroll(float fraction, CatalogModel oldF, CatalogModel newF) {
        weatherImage.setScaleX(fraction);
        weatherImage.setScaleY(fraction);
        currentGradient = mix(fraction,
                productBackGroundChange(newF.getProductBackGround()),
                productBackGroundChange(oldF.getProductBackGround()));
        initGradient();
        invalidate();
    }

    private int[] mix(float fraction, int[] c1, int[] c2) {
        return new int[]{
                (Integer) evaluator.evaluate(fraction, c1[0], c2[0]),
                (Integer) evaluator.evaluate(fraction, c1[1], c2[1]),
                (Integer) evaluator.evaluate(fraction, c1[2], c2[2])
        };

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (currentGradient != null) {
            initGradient();
        }

    }

    private void initGradient() {
        float centerX = getWidth() * 0.5f;
        Shader gradient = new LinearGradient(
                centerX, 0, centerX, getHeight(),
                currentGradient, null,
                Shader.TileMode.MIRROR);
        gradientPaint.setShader(gradient);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), gradientPaint);
        super.onDraw(canvas);
    }

    public void setWebView(CatalogModel catalogModel)
    {
        ProductBackGround productBackGround = catalogModel.getProductBackGround();
        currentGradient = productBackGroundChange(productBackGround);
        if(getWidth() != 0 && getHeight() != 0)
        {
            initGradient();

        }
        weatherDescription.setText(catalogModel.getProductName());
        weatherTemperature.setText(catalogModel.getProductIcon());
        //wbProduct.loadUrl(catalogModel.getWebUrl());
        Glide.with(getContext()).load(weatherToIcon(productBackGround)).into(weatherImage);
        invalidate();
       /* wbProduct.animate()
                .scaleX(1f).scaleY(1f)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(300)
                .start();
*/
    }

    private int weatherToIcon(ProductBackGround productBackGround) {
        switch (productBackGround) {
            case PERIODIC_CLOUDS:
                return R.drawable.periodic_clouds;
            case CLOUDY:
                return R.drawable.cloudy;
            case MOSTLY_CLOUDY:
                return R.drawable.mostly_cloudy;
            case PARTLY_CLOUDY:
                return R.drawable.partly_cloudy;
            case CLEAR:
                return R.drawable.clear;
            default:
                throw new IllegalArgumentException();
        }

    }

    private int[] productBackGroundChange(ProductBackGround productBackGround) {
        switch (productBackGround) {
            case PERIODIC_CLOUDS:
                return colors(R.array.gradientPeriodicClouds);
            case CLOUDY:
                return colors(R.array.gradientCloudy);
            case MOSTLY_CLOUDY:
                return colors(R.array.gradientMostlyCloudy);
            case PARTLY_CLOUDY:
                return colors(R.array.gradientPartlyCloudy);
            case CLEAR:
                return colors(R.array.gradientClear);
            default:
                throw new IllegalArgumentException();
        }

    }

    private int[] colors(int gradientPeriodicClouds) {

        return getContext().getResources().getIntArray(gradientPeriodicClouds);

    }
}