package com.theme.change;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;
import android.annotation.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		YTheme.setTheme(this);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
			AlertDialog dialog = new AlertDialog.Builder(this)
				.setTitle("主题")
				.setPositiveButton("取消",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				})
				.create();
			dialog.setView(getColorPickerView(dialog));
			dialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
	private void restart() {
        Intent intent = getIntent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

	@SuppressLint("InflateParams")
    private View getColorPickerView(final AlertDialog dialog) {
        final SharedPreferences preferences = getSharedPreferences("item", MODE_PRIVATE);
        LayoutInflater inflater =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView;
        if (inflater != null) {
            rootView = inflater.inflate(R.layout.color_picker, null);
        } else {
            new NullPointerException("inflater is null pointer").printStackTrace();
            return null;
        }

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor spe = preferences.edit();
                switch (v.getId()) {
                    case R.id.itemPurple:
                        spe.putInt("theme", R.style.AppTheme_Purple);
                        break;
                    case R.id.itemGreen:
                        spe.putInt("theme", R.style.AppTheme_Green);
                        break;
                    case R.id.itemDeepOrange:
                        spe.putInt("theme", R.style.AppTheme_DeepOrange);
                        break;
                    case R.id.itemPink:
                        spe.putInt("theme", R.style.AppTheme_Pink);
                        break;
                    case R.id.itemGrey:
                        spe.putInt("theme", R.style.AppTheme_Grey);
                        break;
                    case R.id.itemDeepPurple:
                        spe.putInt("theme", R.style.AppTheme_DeepPurple);
                        break;
                    case R.id.itemIndigo:
                        spe.putInt("theme", R.style.AppTheme_Indigo);
                        break;
                    case R.id.itemTeal:
                        spe.putInt("theme", R.style.AppTheme_Teal);
                        break;
                    case R.id.itemOrange:
                        spe.putInt("theme", R.style.AppTheme_Amber);
                        break;
                    case R.id.itemRed:
                        spe.putInt("theme", R.style.AppTheme_Red);
                        break;
                    case R.id.itemBrown:
                        spe.putInt("theme", R.style.AppTheme_Brown);
                        break;
                    default:
                        spe.putInt("theme", R.style.AppTheme_Blue);
                }

                spe.apply();
                dialog.cancel();
                restart();
            }
        };

        TextView itemPurple = (TextView) rootView.findViewById(R.id.itemPurple);
        TextView itemBlue = (TextView) rootView.findViewById(R.id.itemBlue);
        TextView itemGreen = (TextView) rootView.findViewById(R.id.itemGreen);
        TextView itemDeepOrange = (TextView) rootView.findViewById(R.id.itemDeepOrange);
        TextView itemPink = (TextView) rootView.findViewById(R.id.itemPink);
        TextView itemGrey = (TextView) rootView.findViewById(R.id.itemGrey);
        TextView itemDeepPurple = (TextView) rootView.findViewById(R.id.itemDeepPurple);
        TextView itemIndigo = (TextView) rootView.findViewById(R.id.itemIndigo);
        TextView itemTeal = (TextView) rootView.findViewById(R.id.itemTeal);
        TextView itemAmber = (TextView) rootView.findViewById(R.id.itemOrange);
        TextView itemRed = (TextView) rootView.findViewById(R.id.itemRed);
        TextView itemBrown = (TextView) rootView.findViewById(R.id.itemBrown);

        itemPurple.setOnClickListener(clickListener);
        itemIndigo.setOnClickListener(clickListener);
        itemGreen.setOnClickListener(clickListener);
        itemDeepOrange.setOnClickListener(clickListener);
        itemPink.setOnClickListener(clickListener);
        itemGrey.setOnClickListener(clickListener);
        itemDeepPurple.setOnClickListener(clickListener);
        itemBlue.setOnClickListener(clickListener);
        itemTeal.setOnClickListener(clickListener);
        itemAmber.setOnClickListener(clickListener);
        itemRed.setOnClickListener(clickListener);
        itemBrown.setOnClickListener(clickListener);

        switch (preferences.getInt("theme", 0)) {
            case R.style.AppTheme_Purple:
                itemPurple.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Green:
                itemGreen.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_DeepOrange:
                itemDeepOrange.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Pink:
                itemPink.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Grey:
                itemGrey.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_DeepPurple:
                itemDeepPurple.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Indigo:
                itemIndigo.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Teal:
                itemTeal.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Amber:
                itemAmber.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Red:
                itemRed.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            case R.style.AppTheme_Brown:
                itemBrown.setBackground(getDrawable(R.drawable.yuan_double));
                break;
            default:
                itemBlue.setBackground(getDrawable(R.drawable.yuan_double));
        }

        return rootView;
    }
}
