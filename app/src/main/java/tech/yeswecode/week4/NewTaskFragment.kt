package tech.yeswecode.week4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tech.yeswecode.week4.databinding.FragmentNewTaskBinding
import java.lang.NullPointerException

interface OnNewTaskListener {
    fun onNewTask(task: String)
}

class NewTaskFragment : Fragment() {

    private var _binding: FragmentNewTaskBinding? = null
    private val binding get() = _binding!!

    var listener: OnNewTaskListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addBtn.setOnClickListener {
            val text = binding.taskET.text.toString()
            Log.d("NewTaskFragment", text)

            listener?.let {
                it.onNewTask(text)
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewTaskFragment()
    }
}