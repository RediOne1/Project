package pum.android.project.seba;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;


import pum.android.project.R;
import pum.android.project.RecipeTab.RecipesFragment;
import pum.android.project.tools.displayingbitmaps.ImageCache;
import pum.android.project.tools.displayingbitmaps.ImageFetcher;

/**
 * Created by seba on 18.05.15.
 */
/*
Przekazuje dane do nowo powstałego fragmentu
 */
public class IngridientsActivity extends FragmentActivity
{
    private ImageFetcher imageFetcher;
    private static final String IMAGE_CACHE_DIR = "images";
    private void prepareImageFetcher() {
        // Fetch screen height and width, to use as our max size when loading images as this
        // activity runs full screen
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;
        // For this sample we'll use half of the longest width to resize our images. As the
        // image scaling ensures the image is larger than this, we should be left with a
        // resolution that is appropriate for both portrait and landscape. For best image quality
        // we shouldn't divide by 2, but this will use more memory and require a larger memory
        // cache.
        final int longest = (height > width ? height : width) / 2;

        ImageCache.ImageCacheParams cacheParams =
                new ImageCache.ImageCacheParams(this, IMAGE_CACHE_DIR);
        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory
        imageFetcher = new ImageFetcher(this, longest);
        imageFetcher.addImageCache(getSupportFragmentManager(), cacheParams);
    }

    public ImageFetcher getImageFetcher() {
        return imageFetcher;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareImageFetcher();
        setContentView(R.layout.ingridients_activity);
        String post=getIntent().getStringExtra("post");

        Bundle message = new Bundle();
        RecipesFragment fragment =  new RecipesFragment();
        message.putString("post",post);
        fragment.setArguments(message);
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.lodowka_activ, fragment);
        fragmentTransaction.commit();


    }


}
