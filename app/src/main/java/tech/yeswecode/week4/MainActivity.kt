package tech.yeswecode.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: BottomNavigationView

    private lateinit var newTaskFragment: NewTaskFragment

    private lateinit var taskListFragment: TaskListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newTaskFragment = NewTaskFragment.newInstance()
        taskListFragment = TaskListFragment.newInstance()

        navigator = findViewById(R.id.navigator)
        navigator.setOnItemSelectedListener {
            if(it.itemId == R.id.newItem) {
                showFragment(newTaskFragment)
            } else if(it.itemId == R.id.listItem) {
                showFragment(taskListFragment)
            }
            true
        }

        showFragment(newTaskFragment)
    }

    fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}