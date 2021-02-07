package io.github.turskyi.smsexample

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/** working only on real device
 *  @see [https://youtu.be/mdq0R2WQssQ]
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        /* the package name of this app */
        val myPackageName = packageName
        /* comparing to the default program package name */
        if (Telephony.Sms.getDefaultSmsPackage(this) != myPackageName) {
            /* Our program has not been selected. */

                /** Displaying the button */

            /* Displaying a dialogue box for selection */
            val button: Button = findViewById<View>(R.id.button_change_default_app) as Button
            button.visibility = View.VISIBLE
            button.setOnClickListener {
                val intent = Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT)
                intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, myPackageName)
                startActivity(intent)
            }
        } else {
          /* If our program is the default program */
            val button: Button = findViewById<View>(R.id.button_change_default_app) as Button
            button.visibility = View.GONE
        }
    }
}