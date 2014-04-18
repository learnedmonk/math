package com.learnedmonk.math.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.learnedmonk.math.R;
import com.learnedmonk.math.db.DB;

public class TablesActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	private DB db = null;
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		db = new DB(getBaseContext());
		setContentView(R.layout.pagerview_layout);
	//	setTheme(R.style.TitleBar);
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS );

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						
						actionBar.setSelectedNavigationItem(position);
						db.setTablePosition(position);
					}
				});

		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			actionBar.addTab(actionBar.newTab()
				.setText(mSectionsPagerAdapter.getPageTitle(i))
				.setTabListener(this));
		}
		
		actionBar.setSelectedNavigationItem(db.getTablePosition());
	}


	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new TableSectionFragment();
			Bundle args = new Bundle();
			args.putInt(TableSectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 30;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			position++;
			return ""+position;
			
		}
	}

	public static class TableSectionFragment extends Fragment {
		
		public static final String ARG_SECTION_NUMBER = "section_number";

		public int getArgSectionNumber() {
			return getArguments().getInt(TableSectionFragment.ARG_SECTION_NUMBER)	;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.table_fragment_layout,
					container, false);
			ListView listView = (ListView) rootView
					.findViewById(R.id.tablescroll);
			
		
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext()
			, R.layout.table_listitem_layout);
			int n = getArgSectionNumber();
			for(int i =1 ;i<=10;i++){
				String s = n+"  x "+i+" = "+n*i;
				adapter.add(s);
			}
			
			listView.setAdapter(adapter);
		
			
			return rootView;
		}
		
		public void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
		}
		@Override
		public void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
		}
	}

}
