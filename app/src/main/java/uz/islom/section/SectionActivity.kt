package uz.islom.section

import android.app.Fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_section.*
import uz.islom.R
import android.app.SearchManager
import android.content.Context



class SectionActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var site = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        site = intent.getIntExtra("site",0)

        setContentView(R.layout.activity_section)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name, R.string.app_name)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        pager.adapter = SectionsPagerAdapter(supportFragmentManager)
        title = resources.getStringArray(R.array.sites)[site]


        tabs.setupWithViewPager(pager)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.section, menu)

        val searchItem = menu.findItem(R.id.action_search)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val searchView: SearchView?
        searchView = searchItem.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return SectionFragment.newInstance(position,site)
        }

        override fun getCount(): Int {
            return when(site){
                0 -> resources.getStringArray(R.array.menu_islom).size
                4 -> resources.getStringArray(R.array.menu_fiqh).size
                else -> resources.getStringArray(R.array.menu_islom).size


            }
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when(site){
                1 -> resources.getStringArray(R.array.menu_islom)[position]
                else -> resources.getStringArray(R.array.menu_islom)[position]

            }
        }
    }
}
