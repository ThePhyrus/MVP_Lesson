package roman.bannikov.mvp_lesson_1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import roman.bannikov.mvp_lesson_1.R
import roman.bannikov.mvp_lesson_1.databinding.FragmentPersonalBinding
import roman.bannikov.mvp_lesson_1.model.ThePerson

class PersonalAdapter() :
    RecyclerView.Adapter<PersonalAdapter.PersonalViewHolder>() {

    private var person: List<ThePerson> = emptyList()


    class PersonalViewHolder(itenView: View) : RecyclerView.ViewHolder(itenView) {
        private val binding = FragmentPersonalBinding.bind(itenView)
        fun bind(personalData: ThePerson) = with(binding) {
            tvUserName.text = personalData.name
            ivAvatar.setImageResource(R.drawable.ava_unknown_300x300)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_personal, parent, false)
        return PersonalViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonalViewHolder, position: Int) {
        holder.bind(person[position])
    }

    override fun getItemCount(): Int {
        return person.size
    }

}


