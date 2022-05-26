package cl.nooc.elixirgames.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import cl.nooc.elixirgames.R
import cl.nooc.elixirgames.databinding.FragmentListBinding
import cl.nooc.elixirgames.viewmodel.GamesViewModel

class ListFragment : Fragment() {

    private lateinit var bingind: FragmentListBinding
    private val viewModel by viewModels<GamesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}