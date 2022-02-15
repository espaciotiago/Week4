package tech.yeswecode.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import tech.yeswecode.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var newTaskFragment: NewTaskFragment

    private lateinit var taskListFragment: TaskListFragment

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        newTaskFragment = NewTaskFragment.newInstance()
        taskListFragment = TaskListFragment.newInstance()

        binding.navigator.setOnItemSelectedListener {
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