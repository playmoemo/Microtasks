package no.ife.hrp.microtasks;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;
import java.util.Vector;


public class MainActivity extends FragmentActivity {

    // must be provided by the length of questions-array
    //private static final int NUMBER_OF_PAGES = 5;
    private static int NUMBER_OF_PAGES;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisePaging();
    }

    private void initialisePaging() {
        Resources res = getResources();
        String[] questions = res.getStringArray(R.array.questions);
        NUMBER_OF_PAGES = questions.length;

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new QuestionPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
            }
        });
    }


/*
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
*/

    private class QuestionPagerAdapter extends FragmentStatePagerAdapter {

        public QuestionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return QuestionPageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }

    /**
     * Disable back-button during a run
     */
    @Override
    public void onBackPressed() {}
}
