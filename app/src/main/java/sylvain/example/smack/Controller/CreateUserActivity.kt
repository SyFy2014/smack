package sylvain.example.smack.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import sylvain.example.smack.R
import sylvain.example.smack.Services.AuthService
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun createUserAvatar(view: View){
        val random = Random()
        // the upper bound is 2 and is not include. So it is 0 or 1
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0 ) {
            userAvatar = "light$avatar"
            } else {
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)
    }

    fun generateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        // I think the codes below is for devices working with Apple's operating system
        // maybe it will be used later
        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"

    }

    fun createUserClicked(view: View){
        AuthService.registerUser(this,"s@s.com", "123456"){complete ->
            if (complete) {

            }

        }
    }
}
