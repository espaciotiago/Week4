package tech.yeswecode.week4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.yeswecode.week4.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment(), OnNewTaskListener {

    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = _binding!!

    private val tasks = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.taskListTV.text = ""
        for(task in tasks) {
            binding.taskListTV.append("${task}\n")
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = TaskListFragment()
    }

    override fun onNewTask(task: String) {
        tasks.add(task)
    }
}