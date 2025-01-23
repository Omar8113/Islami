import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }
}
