package firebasestorage.itideology.com.hereyago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_signUp)
    Button btnSignUP;


    private int mFlipping = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.view_Flipper);
        if (mFlipping == 0) {
            /** Start Flipping */
            flipper.startFlipping();
            mFlipping = 1;

        } else {
            /** Stop Flipping */
            flipper.stopFlipping();
            mFlipping = 0;

        }
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreenActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


    }


}
