package roman.bannikov.mvp_lesson_1.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import roman.bannikov.mvp_lesson_1.R
import roman.bannikov.mvp_lesson_1.databinding.ItemUserBinding
import roman.bannikov.mvp_lesson_1.model.GithubUser

class UserAdapter() :
    RecyclerView.Adapter<GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged() //FIXME DiffUtil? Как его тут использовать?
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return GithubUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

class GithubUserViewHolder(itenView: View) : RecyclerView.ViewHolder(itenView) {
    //FIXME какой из вариантов неуместен? Или оба имеют право на жизнь? Какой лучше? Почему?
    //вариант 1
    private val binding = ItemUserBinding.bind(itenView)
    fun bind(item: GithubUser) = with(binding) {
        tvUserLogin.text = item.login
    }
    //вариант 2
/*    private val tvLogin by lazy { itemView.findViewById<TextView>(R.id.tvUserLogin) }
    fun bind(item:GithubUser) = with(item){
        tvLogin.text = login
    }*/

}