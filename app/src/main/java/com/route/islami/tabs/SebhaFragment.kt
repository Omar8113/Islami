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
    var counter: Int = 0
    var turn: Int = 1
    var tasbeha: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasbehTv.text = "سبحان الله"
        binding.sebhaCounter.text = "0"
        binding.sebha.setOnClickListener {
            tasbeh()
            binding.sebha.rotation += (360 / 33).toFloat()
        }
    }

    private fun tasbeh() {
        tasbeha++
        counter++

        binding.sebhaCounter.text = counter.toString()

        if (counter == 34) {
            turn++
            counter = 0
        }

        if (turn == 1) {
            binding.tasbehTv.text = "سبحان الله"
            binding.sebhaCounter.text = counter.toString()
        }
        if (turn == 2) {
            binding.tasbehTv.text = "الحمد لله"
            binding.sebhaCounter.text = counter.toString()

        }
        if (turn == 3) {
            binding.tasbehTv.text = "الله اكبر"
            binding.sebhaCounter.text = counter.toString()
        }
        if (turn == 4) {
            binding.tasbehTv.text = "لا اله الا الله"
            binding.sebhaCounter.text = counter.toString()
        }

        if (tasbeha == 103) {
            tasbeha = 0
            counter = 0
            turn = 1
            binding.tasbehTv.text = "سبحان الله"
            binding.sebhaCounter.text = counter.toString()
        }
    }

}
