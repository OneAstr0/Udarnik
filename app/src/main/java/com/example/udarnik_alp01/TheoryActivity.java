package com.example.udarnik_alp01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;


public class TheoryActivity extends AppCompatActivity {

    private EditText searchPanel;
    private TextView output;
    private String[] words = {"аэропОрты", "бАнты", "бОроду", "бухгАлтеров", "вероисповЕдание", "водопровОд", "газопровОд", "электропрОвод", "граждАнство", "дефИс", "дешевИзна", "диспансЕр", "договорЁнность", "договорЕнность", "докумЕнт", "досУг", "еретИк", "жалюзИ", "знАчимость", "Иксы", "каталОг", "квартАл", "киломЕтр", "кОнусов", "корЫсть", "крАны", "кремЕнь", "лЕкторов", "лОктя", "лыжнЯ", "мЕстностей", "намЕрение", "нарОст", "нЕдруг", "недУг", "некролОг", "нЕнависть", "нефтепровОд", "новостЕй", "нОгтя", "Отрочество", "партЕр", "портфЕль", "пОручни", "придАное", "призЫв", "свЁкла", "свЕкла", "сирОты", "созЫв", "сосредотОчение", "срЕдства", "стАтуя", "столЯр", "тамОжня", "тОрты", "тУфля", "цемЕнт", "цЕнтнер", "цепОчка", "шАрфы", "шофЁр", "экспЕрт", "вернА", "знАчимый", "красИвее", "красИвейший", "кУхонный", "ловкА", "мозаИчный", "оптОвый", "прозорлИвый", "прозорлИва", "слИвовый", "бралА", "бралАсь", "взялА", "взялАсь", "влилАсь", "ворвалАсь", "воспринЯть", "воссоздалА", "вручИт", "гналА", "гналАсь", "добралА", "добралАсь", "дождалАсь", "дозвонИтся", "дозвонИться", "дозИровать", "ждалА", "жилОсь", "закУпорить", "занЯть", "заперлА", "запломбировАть", "защемИт", "звалА", "звонИт", "звонИть", "кАшлянуть",
            "клАла", "клЕить", "крАлась", "кровоточИть", "лгалА", "лилА", "лилАсь", "навралА", "наврАть", "наделИт", "наделИть", "надорвалАсь", "назвалАсь", "назвАться", "накренИтся", "накренИться", "налилА", "нарвалА", "начАть", "обзвонИт", "облегчИть", "облилАсь", "обнялАсь", "обогналА", "ободралА", "ободрИт", "обострИть", "одолжИть", "озлОбить", "оклЕить", "окружИт", "опОшлить", "освЕдомиться", "отбылА", "отдалА", "откУпорить", "отозвалА", "отозвалАсь", "перезвонИт", "перелилА", "плодоносИть", "пломбировАть", "повторИт", "позвалА", "позвонИт", "звонИть", "полилА", "полИть", "положИл", "понЯть", "понялА", "послАла", "прибЫть", "прИбыл", "прибылА", "прИбыли", "прИнял", "принялА", "прИняли", "рвалА", "сверлИт", "снялА", "совралА", "соврАть", "создалА", "создАть", "сорвалА", "сорвАть", "сорИт", "сорИть", "убралА", "убрАть", "углубИть", "укрепИт", "укрепИть", "чЕрпать", "щемИт", "щЁлкать", "щЕлкать", "довезЁнный", "зАгнутый", "зАнятый", "занятА", "зАпертый", "заселенА", "кормЯщий", "кровоточАщий", "нажИвший", "налИвший", "нанЯвшийся", "нАчатый", "низведЁнный", "облегчЁнный", "ободрЁнный", "обострЁнный", "отключЁнный", "повторЁнный", "поделЁнный", "понЯвший", "прИнятый", "принятА",
            "приручЁнный", "приручЕнный", "прожИвший", "снятА", "сОгнутый", "углублЁнный", "углублЕнный", "закУпорив", "начАв", "начАвшись", "отдАв", "поднЯв", "понЯв", "прибЫв", "создАв", "вОвремя", "дОверху", "донЕльзя",
            "дОнизу", "дОсуха", "зАсветло", "зАтемно", "красИвее", "надОлго", "ненадОлго", "шофЁр", "избалОванный", "принУдить"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        searchPanel = findViewById(R.id.search_panel);
        output = findViewById(R.id.output);

        // управление текстом в скролменю
        Button btnNoun = findViewById(R.id.btnNoun);
        Button btnAdjective = findViewById(R.id.btnAdjective);
        Button btnVerb = findViewById(R.id.btnVerb);
        Button btnParticiple = findViewById(R.id.btnParticiple);
        Button btnAdvParticiple = findViewById(R.id.btnAdvParticiple);
        Button btnAdverb = findViewById(R.id.btnAdverb);

        final ScrollView scrollView = findViewById(R.id.scrollView);

        final TextView titleNoun = findViewById(R.id.titleNoun);
        final TextView titleAdjective = findViewById(R.id.titleAdjective);
        final TextView titleVerb = findViewById(R.id.titleVerb);
        final TextView titleParticiple = findViewById(R.id.titleParticiple);
        final TextView titleAdvParticiple = findViewById(R.id.titleAdvParticiple);
        final TextView titleAdverb = findViewById(R.id.titleAdverb);


        // подъём вверх
        AppCompatImageButton btnUp = (AppCompatImageButton) findViewById(R.id.btnUp);
        btnUp.setVisibility(View.GONE);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView.getScrollY() > 0) {
                    btnUp.setVisibility(View.VISIBLE);
                } else {
                    btnUp.setVisibility(View.GONE);
                }
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0);
                btnUp.setVisibility(View.GONE);
            }
        });



        // перемещение к темам
        btnNoun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleNoun.getTop());
            }
        });

        btnAdjective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleAdjective.getTop());
            }
        });

        btnVerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleVerb.getTop());
            }
        });

        btnParticiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleParticiple.getTop());
            }
        });

        btnAdvParticiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleAdvParticiple.getTop());
            }
        });

        btnAdverb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, titleAdverb.getTop());
            }
        });




        // выход назад (в меню)
        findViewById(R.id.btnBackTheory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // обработка поисковых запросов
        searchPanel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // null
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString().toLowerCase();
                for (String word : words) {
                    if (word.toLowerCase().equals(input)) {
                        output.setText("Правильное ударение в слове " + word.toLowerCase() + ": " + word + ".");
                        return;
                    }
                }
                output.setText("Поиск по слову: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // null
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
