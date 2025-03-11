package com.ratila.electro_radioelements;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        LinearLayout container = findViewById(R.id.container);
        TextView textElementInfo = findViewById(R.id.text_element_info);
        ImageView imageElement = findViewById(R.id.image_element);
        TextView textUGO = findViewById(R.id.text_UGO);
        Button buttonBack = findViewById(R.id.button_back);

        String element = getIntent().getStringExtra("element");

        if (element != null) {
            switch (element) {
                case "resistor":
                    textElementInfo.setText("Резистор — это пассивный элемент электрической цепи, который оказывает сопротивление электрическому току.");
                    addTextView(container, "Резистор постоянный: Имеет фиксированное сопротивление, обозначается как R.");
                    imageElement.setImageResource(R.drawable.resistor_image);
                    textUGO.setText("УГО: R, Единица измерения: Ом");
                    addDynamicContent(container, element);
                    break;
                case "capacitor":
                    textElementInfo.setText("Конденсатор — это устройство для накопления заряда и энергии электрического поля. " +
                            "Он состоит из двух проводящих обкладок, разделенных диэлектриком.");
                    imageElement.setImageResource(R.drawable.capacitor_image);
                    addTextView(container, "Конденсатор постоянной ёмкости: C");
                    textUGO.setText("УГО: C, Единица измерения: Фарад");
                    addDynamicContent(container, element);
                    break;
                case "coils":
                    textElementInfo.setText("Катушка индуктивности (дроссель) — это элемент электрической цепи, который накапливает энергию в магнитном поле при протекании тока.");

                    addTextView(container, "Катушка индуктивности: L");
                    imageElement.setImageResource(R.drawable.coil_image);
                    textUGO.setText("УГО: L, Единица измерения: Генри");
                    addDynamicContent(container, element);
                    break;
                case "diods":
                    textElementInfo.setText("Диод — это полупроводниковый прибор, который пропускает ток только в одном направлении.");
                    addTextView(container, "Диод: VD");
                    imageElement.setImageResource(R.drawable.diode_image);
                    textUGO.setText("УГО: VD");
                    addDynamicContent(container, element);
                    break;
                case "transistors":
                    textElementInfo.setText("Транзистор — это полупроводниковый прибор, используемый для усиления и переключения электрических сигналов.");
                    addTextView(container, "Биполярный транзистор: VT");
                    imageElement.setImageResource(R.drawable.transistor_image);
                    textUGO.setText("УГО: VT");
                    addDynamicContent(container, element);
                    break;
                case "fuses":
                    textElementInfo.setText("Предохранитель — это защитное устройство, которое разрывает цепь при превышении тока.");
                    addTextView(container, "Предохранитель плавкий: FU");
                    imageElement.setImageResource(R.drawable.fuse_image);
                    textUGO.setText("УГО: FU");
                    addDynamicContent(container, element);
                    break;
                case "grounding":
                    textElementInfo.setText("Заземление — это соединение электрической цепи с землёй для обеспечения безопасности.");
                    addTextView(container, "Заземление: ┴");
                    imageElement.setImageResource(R.drawable.grounding_image);
                    textUGO.setText("УГО: ┴");
                    addDynamicContent(container, element);
                    break;
                case "contact":
                    textElementInfo.setText("Контакт замыкающий — это элемент, который замыкает электрическую цепь при нажатии.");
                    addTextView(container, "Контакт замыкающий: S");
                    imageElement.setImageResource(R.drawable.contact_image);
                    textUGO.setText("УГО: S");
                    addDynamicContent(container, element);
                    break;
                case "devices":
                    textElementInfo.setText("Электромеханические устройства — это устройства, преобразующие электрическую энергию в механическую.");
                    addTextView(container, "Катушка электромеханического устройства: K");
                    imageElement.setImageResource(R.drawable.device_image);
                    textUGO.setText("УГО: K (реле)");
                    addDynamicContent(container, element);
                    break;
                case "acoustic":
                    textElementInfo.setText("Акустические устройства — это устройства, преобразующие электрические сигналы в звук.");
                    addTextView(container, "Микрофон: BM");
                    imageElement.setImageResource(R.drawable.acoustic_image);
                    textUGO.setText("УГО: BM (микрофон), BA (динамик)");
                    addDynamicContent(container, element);
                    break;
                case "power":
                    textElementInfo.setText("Элемент питания — это источник электрической энергии, например, батарейка.");
                    addTextView(container, "Элемент питания: G (GB)");
                    imageElement.setImageResource(R.drawable.power_image);
                    textUGO.setText("УГО: G (GB)");
                    addDynamicContent(container, element);
                    break;
                case "quartz":
                    textElementInfo.setText("Кварцевый резонатор — это устройство, используемое для стабилизации частоты в электронных схемах.");
                    addTextView(container, "Кварцевый резонатор: BQ (ZQ)");
                    imageElement.setImageResource(R.drawable.quartz_image);
                    textUGO.setText("УГО: BQ (ZQ)");
                    addDynamicContent(container, element);
                    break;
                case "microcircuits":
                    textElementInfo.setText("Микросхемы — это миниатюрные электронные устройства, содержащие множество компонентов.");
                    addTextView(container, "Микросхемы: D (DA — аналоговые, DD — цифровые)");
                    imageElement.setImageResource(R.drawable.microcircuit_image);
                    textUGO.setText("УГО: D (DA — аналоговые, DD — цифровые)");
                    addDynamicContent(container, element);
                    break;
            }
        }

        animateView(textElementInfo, 0);
        animateView(imageElement, 100);
        animateView(textUGO, 200);
        animateView(buttonBack, 300);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addDynamicContent(LinearLayout container, String element) {
        switch (element) {
            case "resistor":
                addImageView(container, R.drawable.resistor_image_2);
                addTextView(container, "Резистор переменный: Позволяет изменять сопротивление вручную, также обозначается как R. " +
                        "Используется в регуляторах громкости, яркости и других устройствах, где требуется плавная настройка параметров. " +
                        "Переменные резисторы бывают поворотные, ползунковые и подстроечные. Поворотные используются в ручках управления, " +
                        "а подстроечные — для точной настройки параметров схемы.");
                addImageView(container, R.drawable.resistor_image_3);
                addTextView(container, "Резистор подстроечный: Используется для точной настройки сопротивления, обозначается как R. " +
                        "Часто применяется в электронных схемах для калибровки и настройки оборудования. Подстроечные резисторы имеют " +
                        "винтовой механизм, который позволяет изменять сопротивление с высокой точностью. Они используются в измерительных " +
                        "приборах, блоках питания и других устройствах, где требуется точная настройка.");
                addImageView(container, R.drawable.resistor_image_4);
                addTextView(container, "Фоторезистор: Меняет сопротивление в зависимости от освещённости, обозначается как R. " +
                        "Используется в датчиках освещённости, автоматических выключателях света и других устройствах, реагирующих на свет. " +
                        "Фоторезисторы изготавливаются из полупроводниковых материалов, таких как сульфид кадмия. При увеличении освещённости " +
                        "их сопротивление уменьшается, что позволяет использовать их в системах автоматического управления освещением.");
                break;

            case "capacitor":
                addImageView(container, R.drawable.capacitor_image_2);
                addTextView(container, "Конденсатор переменной ёмкости: Позволяет изменять ёмкость вручную, обозначается как C. " +
                        "Применяется в радиоприёмниках для настройки частоты и в других устройствах, где требуется регулировка ёмкости. " +
                        "Переменные конденсаторы состоят из подвижных и неподвижных пластин, которые образуют обкладки. При вращении " +
                        "ручки пластины сдвигаются или раздвигаются, изменяя ёмкость.");
                addImageView(container, R.drawable.capacitor_image_3);
                addTextView(container, "Конденсатор электролитический: Используется в цепях с постоянным током, обозначается как C. " +
                        "Имеет полярность, поэтому важно правильно подключать его в схему. Электролитические конденсаторы имеют большую " +
                        "ёмкость и используются в фильтрах питания, для сглаживания пульсаций и в качестве накопителей энергии. " +
                        "Они изготавливаются из алюминиевой или танталовой фольги, пропитанной электролитом.");
                break;

            case "coils":
                addImageView(container, R.drawable.coil_image_2);
                addTextView(container, "Трансформатор однофазный: Преобразует напряжение одной величины в напряжение другой величины, обозначается как T. " +
                        "Состоит из двух или более катушек, намотанных на общий магнитопровод. Используется в блоках питания и электрических сетях. " +
                        "Трансформаторы бывают повышающие (увеличивают напряжение) и понижающие (уменьшают напряжение). Они также используются " +
                        "для гальванической развязки цепей, что повышает безопасность.");
                break;

            case "diods":
                addImageView(container, R.drawable.diode_image_2);
                addTextView(container, "Стабилитрон: Используется для стабилизации напряжения, обозначается как VD. " +
                        "Работает в режиме пробоя, поддерживая постоянное напряжение на своих выводах. Применяется в стабилизаторах напряжения. " +
                        "Стабилитроны изготавливаются из кремния и имеют строго определённое напряжение пробоя. Они используются в источниках " +
                        "питания, где требуется стабильное напряжение, например, в блоках питания компьютеров.");
                addImageView(container, R.drawable.diode_image_3);
                addTextView(container, "Светодиод: Излучает свет при прохождении тока, обозначается как HL. " +
                        "Используется в индикаторах, подсветке и осветительных приборах. Имеет полярность, поэтому важно правильно подключать. " +
                        "Светодиоды изготавливаются из полупроводниковых материалов, таких как арсенид галлия. Они отличаются высокой " +
                        "энергоэффективностью и долговечностью. Современные светодиоды используются в LED-лампах, экранах и фонарях.");
                addImageView(container, R.drawable.diode_image_4);
                addTextView(container, "Фотодиод: Преобразует свет в электрический ток, обозначается как BL. " +
                        "Используется в датчиках освещённости, солнечных батареях и оптических устройствах. Фотодиоды работают на основе " +
                        "фотоэлектрического эффекта: при попадании света на полупроводниковый материал генерируется электрический ток. " +
                        "Они применяются в системах автоматического управления, оптических коммуникациях и солнечных панелях.");
                break;

            case "transistors":
                addTextView(container, "Биполярный транзистор: Управляет током с помощью малого входного сигнала, обозначается как VT. " +
                        "Имеет три вывода: эмиттер, базу и коллектор. Используется для усиления сигналов и переключения цепей. " +
                        "Биполярные транзисторы бывают двух типов: NPN и PNP. Они широко применяются в усилителях звука, радиопередатчиках " +
                        "и цифровых схемах. Транзисторы являются основными элементами современных интегральных схем.");
                break;

            case "fuses":
                addTextView(container, "Предохранитель плавкий: Защищает электрические цепи от перегрузок и коротких замыканий, обозначается как FU. " +
                        "Состоит из тонкой проволоки, которая плавится при превышении тока. После срабатывания требует замены. " +
                        "Предохранители бывают стеклянные, керамические и с индикатором срабатывания. Они используются в бытовой технике, " +
                        "автомобилях и промышленном оборудовании для предотвращения повреждений от перегрузок.");
                break;

            case "grounding":
                addTextView(container, "Заземление: Обеспечивает безопасность, соединяя электрическую цепь с землёй, обозначается как ┴. " +
                        "Используется для защиты от поражения электрическим током и предотвращения накопления статического заряда. " +
                        "Заземление также улучшает стабильность работы электронных устройств, снижая уровень помех. В быту заземление " +
                        "применяется в розетках, стиральных машинах и других приборах, где есть риск утечки тока.");
                break;

            case "contact":
                addImageView(container, R.drawable.contact_image_2);
                addTextView(container, "Выключатель кнопочный: Управляется нажатием, обозначается как SB. " +
                        "Используется в устройствах, где требуется временное замыкание или размыкание цепи, например, в дверных звонках. " +
                        "Кнопочные выключатели бывают нормально разомкнутые (замыкают цепь при нажатии) и нормально замкнутые (размыкают цепь при нажатии). " +
                        "Они применяются в системах управления, пультах и бытовой технике.");
                break;

            case "devices":
                addTextView(container, "Катушка электромеханического устройства: Используется в реле, обозначается как K. " +
                        "При подаче тока создаёт магнитное поле, которое приводит в движение механические части устройства. " +
                        "Реле используются для управления высоковольтными цепями с помощью низковольтных сигналов. Они применяются " +
                        "в автоматике, системах управления и защитных устройствах.");
                break;

            case "acoustic":
                addImageView(container, R.drawable.acoustic_image_2);
                addTextView(container, "Динамик: Преобразует электрический сигнал в звук, обозначается как BA. " +
                        "Используется в аудиосистемах, телефонах и других устройствах, где требуется воспроизведение звука. " +
                        "Динамики состоят из магнита, катушки и мембраны. При подаче тока катушка взаимодействует с магнитным полем, " +
                        "вызывая колебания мембраны, которые создают звуковые волны.");
                break;

            case "power":
                addTextView(container, "Элемент питания: Источник электрической энергии, например, батарейка, обозначается как G (GB). " +
                        "Используется в портативных устройствах, где требуется автономное питание. Батарейки бывают одноразовые " +
                        "(щелочные, солевые) и перезаряжаемые (литий-ионные, никель-металлогидридные). Они применяются в часах, " +
                        "пультах управления, фонариках и других устройствах.");
                break;

            case "quartz":
                addTextView(container, "Кварцевый резонатор: Используется для стабилизации частоты в электронных схемах, обозначается как BQ (ZQ). " +
                        "Применяется в часах, генераторах частоты и других устройствах, где требуется высокая точность. " +
                        "Кварцевые резонаторы работают на основе пьезоэлектрического эффекта: при подаче напряжения кварц начинает " +
                        "колебаться с определённой частотой. Это позволяет создавать стабильные и точные генераторы сигналов.");
                break;

            case "microcircuits":
                addTextView(container, "Микросхемы: Миниатюрные электронные устройства, содержащие множество компонентов, обозначаются как D. " +
                        "Аналоговые микросхемы (DA) используются для обработки сигналов, цифровые (DD) — для логических операций. " +
                        "Микросхемы изготавливаются на кремниевых подложках и содержат транзисторы, резисторы, конденсаторы и другие элементы. " +
                        "Они применяются в компьютерах, телефонах, бытовой технике и других устройствах.");
                break;
        }
    }

    private void addTextView(LinearLayout container, String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(18);
        textView.setTextColor(getResources().getColor(android.R.color.white));
        textView.setTypeface(getResources().getFont(R.font.font1));
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textView.setPadding(0, 0, 0, 16);
        container.addView(textView);
        animateView(textView, container.getChildCount() * 100);
    }

    private void addImageView(LinearLayout container, int imageRes) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(imageRes);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        imageView.setPadding(0, 0, 0, 16);
        container.addView(imageView);
        animateView(imageView, container.getChildCount() * 100);
    }

    private void animateView(View view, long delay) {
        view.setVisibility(View.INVISIBLE);
        view.postDelayed(() -> {
            view.setVisibility(View.VISIBLE);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(500);
            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 100, 0);
            translateAnimation.setDuration(500);
            view.startAnimation(alphaAnimation);
            view.startAnimation(translateAnimation);
        }, delay);
    }
}