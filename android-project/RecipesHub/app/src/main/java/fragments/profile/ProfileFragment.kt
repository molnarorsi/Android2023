package fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recipeshub.R
import com.example.recipeshub.databinding.FragmentProfileBinding

//class ProfileFragment : Fragment() {
//    private var _binding: FragmentProfileBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentProfileBinding.inflate(inflater, container, false)
//        binding.fab.setOnClickListener{
//            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
//        }
//        return binding.root
//    }
//
//}