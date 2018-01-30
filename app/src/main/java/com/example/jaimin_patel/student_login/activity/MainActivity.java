//Author : Jaimin Patel

package com.example.jaimin_patel.student_login.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.jaimin_patel.student_login.Fragment.frag_counseling;
import com.example.jaimin_patel.student_login.Fragment.frag_home;
import com.example.jaimin_patel.student_login.Fragment.frag_logout;
import com.example.jaimin_patel.student_login.R;
import com.example.jaimin_patel.student_login.helper.SQLiteHandler;
import com.example.jaimin_patel.student_login.helper.SessionManager;

import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

	private android.support.v7.app.ActionBar toolbar;


	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = getSupportActionBar();
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


		setTitle("Student Counseling");

	}

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			Fragment fragment;
			switch (item.getItemId()) {
				case R.id.home:
					toolbar.setTitle("Home");
					fragment = new frag_home();
					loadfragment(fragment);

					return true;
				case R.id.counseling:
					toolbar.setTitle("Couneling");
					fragment = new frag_counseling();
					loadfragment(fragment);
					return true;
				case R.id.favourite:
					toolbar.setTitle("Favourite");
					return true;
				case R.id.profile:
					toolbar.setTitle("Profile");
					return true;

				case R.id.logout:
					toolbar.setTitle("Logout");
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
