//Author : Jaimin Patel

package com.example.jaimin_patel.student_login.activity;


import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.jaimin_patel.student_login.BottomNavigationBehavior.BottomNavigationBehavior;
import com.example.jaimin_patel.student_login.Fragment.frag_counseling;
import com.example.jaimin_patel.student_login.Fragment.frag_favourite;
import com.example.jaimin_patel.student_login.Fragment.frag_home;
import com.example.jaimin_patel.student_login.Fragment.frag_logout;
import com.example.jaimin_patel.student_login.Fragment.frag_profile;
import com.example.jaimin_patel.student_login.R;



public class MainActivity extends AppCompatActivity {
	private Toolbar mTopToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new frag_home()).commit();
		}


		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		// attaching bottom sheet behaviour - hide / show on scroll
		CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
		layoutParams.setBehavior(new BottomNavigationBehavior());
		setTitle("Student Counseling");

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_favorite) {
			Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			Fragment fragment;
			switch (item.getItemId()) {
				case R.id.home:
					fragment = new frag_home();
					loadfragment(fragment);

					return true;
				case R.id.counseling:
					fragment = new frag_counseling();
					loadfragment(fragment);
					return true;
				case R.id.favourite:
					fragment = new frag_favourite();
					loadfragment(fragment);
					return true;
				case R.id.profile:
					fragment = new frag_profile();
					loadfragment(fragment);
					return true;

				case R.id.logout:

					fragment = new frag_logout();
					loadfragment(fragment);
					return true;
			}
			return false;
		}
	};

	private void loadfragment(Fragment fragment) {
		// load fragments here..

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.frame_container, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}


}
