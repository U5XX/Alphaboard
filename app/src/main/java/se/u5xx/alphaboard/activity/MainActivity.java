package se.u5xx.alphaboard.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import se.u5xx.alphaboard.BuildConfig;
import se.u5xx.alphaboard.R;
import se.u5xx.alphaboard.adapter.FragmentAdapter;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    FragmentAdapter mViewPagerAdapter;

    private Timber.DebugTree timberDebugTree = new Timber.DebugTree();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initComponents();

        if (BuildConfig.DEBUG)
            Timber.plant(timberDebugTree); // Enable log on debug builds.

        if (null != getSupportActionBar()) getSupportActionBar().setTitle(R.string.app_name);
    }

    private void initComponents() {
        setSupportActionBar(mToolbar);
        mViewPagerAdapter = new FragmentAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOnPageChangeListener(onPageChangeListener);

    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mToolbar.setTitle(R.string.app_name);
                    mToolbar.setSubtitle(R.string.subtitle_categories);
                    break;
                case 1:
                    mToolbar.setTitle(R.string.app_name);
                    mToolbar.setSubtitle(R.string.subtitle_favorites);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            // TODO
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
