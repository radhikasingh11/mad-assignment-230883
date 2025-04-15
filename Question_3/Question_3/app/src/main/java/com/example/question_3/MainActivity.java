package com.example.question_3;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView surprise, dynamicIsland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        surprise = findViewById(R.id.surprise);
        dynamicIsland = findViewById(R.id.dynamicIsland); // 🔥 using appleid.json

        if (surprise != null) {
            surprise.setAnimation(R.raw.hello);
            surprise.setRepeatCount(LottieDrawable.INFINITE);
            surprise.playAnimation();
        }

        if (dynamicIsland != null) {
            dynamicIsland.setAnimation(R.raw.loading1); // Apple ID animation (Dynamic Island)
            dynamicIsland.setRepeatCount(LottieDrawable.INFINITE);
            dynamicIsland.playAnimation();
        }
    }
}

