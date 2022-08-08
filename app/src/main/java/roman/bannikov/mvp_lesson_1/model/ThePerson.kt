package roman.bannikov.mvp_lesson_1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThePerson(
    val name: String,
    val ava: Int
) : Parcelable
