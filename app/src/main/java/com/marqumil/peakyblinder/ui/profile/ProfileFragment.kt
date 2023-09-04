package com.marqumil.peakyblinder.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.marqumil.peakyblinder.databinding.FragmentProfileBinding
import com.marqumil.peakyblinder.ui.auth.UserViewModel
import com.marqumil.peakyblinder.ui.auth.login.LoginActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        val userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProfile

        binding.apply {
            if (userViewModel.isUserSignedIn()) {
                tvEmail.text = userViewModel.getEmail().toString()

                if (userViewModel.getUsername().toString() == "" || userViewModel.getUsername().toString() == "null" || userViewModel.getUsername().toString() == " " || userViewModel.getUsername().toString() == null) {
                    // cut the email name before @
                    val email = userViewModel.getEmail().toString()
                    val index = email.indexOf("@")
                    val name = email.substring(0, index)
                    tvProfileName.text = name
                } else {
                    tvProfileName.text = userViewModel.getUsername().toString()
                }
            } else {
                tvEmail.text = "Not logged in"
                tvProfileName.text = "Not logged in"
            }



            btnLogout.setOnClickListener {
                userViewModel.signOut()
                if (!userViewModel.isUserSignedIn()) {
                    Intent(requireContext(), LoginActivity::class.java).also {
                        startActivity(it)
                        requireActivity().finish()
                    }
                }
            }
        }

//        profileViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}