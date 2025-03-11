package com.ratila.electro_radioelements;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonResistors = findViewById(R.id.button_resistor);
        Button buttonCapacitor = findViewById(R.id.button_capacitor);
        Button buttonCoils = findViewById(R.id.button_Coils);
        Button buttonDiods = findViewById(R.id.button_diods);
        Button buttonTransistors = findViewById(R.id.button_transistors);
        Button buttonFuses = findViewById(R.id.button_fuses);
        Button buttonGrounding = findViewById(R.id.button_grounding);
        Button buttonContact = findViewById(R.id.button_contact);
        Button buttonDevices = findViewById(R.id.button_devices);
        Button buttonAcoustic = findViewById(R.id.button_acoustic);
        Button buttonPower = findViewById(R.id.button_power);
        Button buttonQuartz = findViewById(R.id.button_quartz);
        Button buttonMicrocircuits = findViewById(R.id.button_microcircuits);
        setupButtonWithAnimation(buttonResistors, "resistor");
        setupButtonWithAnimation(buttonCapacitor, "capacitor");
        setupButtonWithAnimation(buttonCoils, "coils");
        setupButtonWithAnimation(buttonDiods, "diods");
        setupButtonWithAnimation(buttonTransistors, "transistors");
        setupButtonWithAnimation(buttonFuses, "fuses");
        setupButtonWithAnimation(buttonGrounding, "grounding");
        setupButtonWithAnimation(buttonContact, "contact");
        setupButtonWithAnimation(buttonDevices, "devices");
        setupButtonWithAnimation(buttonAcoustic, "acoustic");
        setupButtonWithAnimation(buttonPower, "power");
        setupButtonWithAnimation(buttonQuartz, "quartz");
        setupButtonWithAnimation(buttonMicrocircuits, "microcircuits");
    }
    private void setupButtonWithAnimation(Button button, final String element) {
        button.setOnTouchListener(new View.OnTouchListener() {
            private float startX, startY;
            private boolean isScrolling = false;
            private final int SCROLL_THRESHOLD = 30; // Увеличенный порог для определения скролла
            private final int PRESS_DELAY = 300; // Увеличенная задержка для подтверждения нажатия
            private Handler handler = new Handler(Looper.getMainLooper());
            private Runnable transitionRunnable;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        startY = event.getY();
                        isScrolling = false;
                        v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_down));

                        // Запускаем отложенный переход
                        transitionRunnable = new Runnable() {
                            @Override
                            public void run() {
                                if (!isScrolling) {
                                    Intent intent = new Intent(MainActivity.this, ElementActivity.class);
                                    intent.putExtra("element", element);
                                    startActivity(intent);
                                }
                            }
                        };
                        handler.postDelayed(transitionRunnable, PRESS_DELAY);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float deltaX = Math.abs(event.getX() - startX);
                        float deltaY = Math.abs(event.getY() - startY);

                        if (deltaX > SCROLL_THRESHOLD || deltaY > SCROLL_THRESHOLD) {
                            isScrolling = true;
                            handler.removeCallbacks(transitionRunnable);
                            v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up));
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        handler.removeCallbacks(transitionRunnable);
                        v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_up));

                        if (!isScrolling) {
                            // Дополнительная проверка для предотвращения случайного клика
                            if (Math.abs(event.getX() - startX) < SCROLL_THRESHOLD / 2 &&
                                    Math.abs(event.getY() - startY) < SCROLL_THRESHOLD / 2) {
                                Intent intent = new Intent(MainActivity.this, ElementActivity.class);
                                intent.putExtra("element", element);
                                startActivity(intent);
                            }
                        }
                        isScrolling = false;
                        break;
                }
                return true;
            }
        });
    }


}
